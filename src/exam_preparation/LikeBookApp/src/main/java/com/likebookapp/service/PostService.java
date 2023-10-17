package com.likebookapp.service;

import com.likebookapp.model.dto.CreatePostDTO;
import com.likebookapp.model.dto.HomePageDTO;

public interface PostService {

    HomePageDTO getHomePageDTO();

    boolean create(CreatePostDTO createPostDTO);

    void remove(Long id);

    void like(Long id);
}
