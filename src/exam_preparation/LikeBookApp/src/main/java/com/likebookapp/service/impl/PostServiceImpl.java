package com.likebookapp.service.impl;

import com.likebookapp.model.dto.CreatePostDTO;
import com.likebookapp.model.dto.HomePageDTO;
import com.likebookapp.model.dto.PostDTO;
import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MoodRepository moodRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, MoodRepository moodRepository, UserRepository userRepository, UserService userService, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.moodRepository = moodRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public HomePageDTO getHomePageDTO() {
        String loggedUsername = userService.getLoggedUsername();
        List<PostDTO> myPosts = getPostsByUser(loggedUsername);
        List<PostDTO> otherPosts = getPostsNotByUser(loggedUsername);

        return new HomePageDTO(loggedUsername, myPosts, otherPosts);
    }

    @Override
    public boolean create(CreatePostDTO createPostDTO) {
        MoodEntity mood = moodRepository
                .findByName(createPostDTO.getMood())
                .orElse(null);

        UserEntity loggedUser = userRepository
                .findByUsername(userService.getLoggedUsername())
                .orElse(null);

        if (mood == null || loggedUser == null) {
            return false;
        }

        PostEntity postEntity = new PostEntity()
                .setContent(createPostDTO.getContent())
                .setMood(mood)
                .setUser(loggedUser);

        loggedUser.addPost(postEntity);

        postRepository.save(postEntity);
        userRepository.save(loggedUser);

        return true;
    }

    @Override
    @Transactional
    public void remove(Long id) {
        UserEntity loggedUser = userRepository
                .findByUsername(userService.getLoggedUsername())
                .orElse(null);

        PostEntity postToDelete = postRepository.findById(id)
                .orElse(null);

        if (loggedUser == null || postToDelete == null) {
            return;
        }

        loggedUser.removePost(postToDelete);

        postRepository.delete(postToDelete);
        userRepository.save(loggedUser);
    }

    @Override
    public void like(Long id) {
        UserEntity loggedUser = userRepository
                .findByUsername(userService.getLoggedUsername())
                .orElse(null);

        PostEntity post = postRepository.findPostWithLikesById(id);

        if (loggedUser == null || post == null) {
            return;
        }

        post.addUserLike(loggedUser);

        postRepository.save(post);
    }

    private List<PostDTO> getPostsByUser(String username) {
        return mapEntitiesToPostDTOs(postRepository.findAllByUserUsernameWithLikes(username));
    }

    private List<PostDTO> getPostsNotByUser(String username) {
        return mapEntitiesToPostDTOs(postRepository.findAllByUserUsernameNotWithLikes(username));
    }

    private List<PostDTO> mapEntitiesToPostDTOs(List<PostEntity> entities) {
        return entities.stream()
                .map(e -> modelMapper.map(e, PostDTO.class))
                .collect(Collectors.toList());
    }


}
