package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.HomePageDTO;
import com.example.spotifyplaylistapp.model.dto.SongAddDTO;

public interface SongService {

    boolean add(SongAddDTO songAddDTO);

    HomePageDTO getHomePageDTO();

    void addToPlaylist(Long id);

    void clearUserPlaylist();
}
