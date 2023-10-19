package com.example.spotifyplaylistapp.model.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HomePageDTO {

    private Map<String, List<SongDTO>> allSongsByStyles;

    List<SongDTO> userPlayList;

    public HomePageDTO() {
    }

    public HomePageDTO(Map<String, List<SongDTO>> allSongsByStyles, List<SongDTO> userPlayList) {
        this.allSongsByStyles = allSongsByStyles;
        this.userPlayList = userPlayList;
    }

    public Map<String, List<SongDTO>> getAllSongsByStyles() {
        return allSongsByStyles;
    }

    public List<SongDTO> getUserPlayList() {
        return userPlayList;
    }

    public String playlistTotalDuration () {
        int totalDuration = userPlayList
                .stream()
                .map(SongDTO::getDuration).mapToInt(Integer::intValue)
                .sum();

        Integer minutes = totalDuration / 60;
        Integer seconds = totalDuration % 60;

        return String.format("%d:%02d", minutes, seconds);
    }
}
