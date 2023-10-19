package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.dto.HomePageDTO;
import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.dto.SongDTO;
import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final StyleRepository styleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public SongServiceImpl(SongRepository songRepository, StyleRepository styleRepository, UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean add(SongAddDTO songAddDTO) {
        SongEntity song = modelMapper.map(songAddDTO, SongEntity.class);
        Optional<StyleEntity> styleOpt = styleRepository.findByName(songAddDTO.getStyleName());

        if (styleOpt.isEmpty()) {
            return false;
        }

        song.setStyle(styleOpt.get());
        songRepository.save(song);

        return true;
    }

    @Override
    public HomePageDTO getHomePageDTO() {
        Map<String, List<SongDTO>> allSongs = new HashMap<>();

        List<StyleEntity> stylesWithSongs = styleRepository.findAllStylesWithSongs();

        for (StyleEntity style : stylesWithSongs) {
            String styleName = style.getName().name();

            List<SongDTO> songs = style.getSongs()
                    .stream()
                    .map(s -> modelMapper.map(s, SongDTO.class))
                    .collect(Collectors.toList());

            allSongs.put(styleName, songs);
        }

        List<SongDTO> userPlayList = userRepository
                .findUserWitPlaylist(loggedUser.getUsername())
                .getPlaylist()
                .stream().map(s -> modelMapper.map(s, SongDTO.class))
                .collect(Collectors.toList());

        return new HomePageDTO(allSongs, userPlayList);
    }

    @Override
    public void addToPlaylist(Long id) {
        SongEntity song = songRepository.getById(id);

        UserEntity user = userRepository.findUserWitPlaylist(loggedUser.getUsername());

        user.getPlaylist().add(song);

        userRepository.save(user);
    }

    @Override
    public void clearUserPlaylist() {
        UserEntity user = userRepository.findUserWitPlaylist(loggedUser.getUsername());
        Set<SongEntity> playlist = user.getPlaylist();
        playlist.clear();
        userRepository.save(user);
    }
}
