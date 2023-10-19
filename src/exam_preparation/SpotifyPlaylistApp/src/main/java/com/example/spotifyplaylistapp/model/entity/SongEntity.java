package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class SongEntity extends BaseEntity {

    //performer: not null, length must be between 3 and 20 characters (inclusive of 3 and 20)
    @Column(nullable = false)
    private String performer;

    //title: not null, length must be between 2 and 20 characters (inclusive of 2 and 20).
    @Column(nullable = false)
    private String title;

    //duration: not null, must be a positive number
    @Column(nullable = false)
    private Integer duration;

    //releaseDate: cannot be in the future
    @Column(name= "release_date")
    private LocalDate releaseDate;

    //style: not null
    @ManyToOne(optional = false)
    private StyleEntity style;

    public SongEntity() {
    }

    public String getPerformer() {
        return performer;
    }

    public SongEntity setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongEntity setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongEntity setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleEntity getStyle() {
        return style;
    }

    public SongEntity setStyle(StyleEntity style) {
        this.style = style;
        return this;
    }
}
