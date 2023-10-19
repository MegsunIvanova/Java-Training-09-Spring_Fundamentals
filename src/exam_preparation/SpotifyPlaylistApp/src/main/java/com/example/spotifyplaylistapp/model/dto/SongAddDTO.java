package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.model.enums.StyleName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class SongAddDTO {

    @NotEmpty (message = "Performer cannot be empty!")
    @Size(min = 3, max = 20, message = "Performer length must be between 3 and 20 characters!")
    private String performer;

    @NotEmpty (message = "Title cannot be empty!")
    @Size(min = 2, max = 20, message = "Title length must be between 2 and 20 characters!")
    private String title;

    //releaseDate: cannot be in the future
    @PastOrPresent (message = "Release date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotNull(message = "Duration cannot be null!")
    @Positive(message = "Duration must be positive!")
    private Integer duration;

    @NotNull(message = "Please select style!")
    private StyleName styleName;

    public SongAddDTO() {
    }

    public String getPerformer() {
        return performer;
    }

    public SongAddDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongAddDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongAddDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddDTO setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public StyleName getStyleName() {
        return styleName;
    }

    public SongAddDTO setStyleName(StyleName styleName) {
        this.styleName = styleName;
        return this;
    }
}
