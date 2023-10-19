package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "styles")
@NamedEntityGraph(
        name = "styleWithSongs",
        attributeNodes = @NamedAttributeNode("songs")
)
public class StyleEntity extends BaseEntity{

    //name: unique, not null
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private StyleName name;

    private String description;

    @OneToMany(mappedBy = "style", targetEntity = SongEntity.class)
    private Set<SongEntity> songs;

    public StyleEntity() {
        this.songs = new HashSet<>();
    }

    public StyleEntity(StyleName name) {
        this.name = name;
    }

    public StyleName getName() {
        return name;
    }

    public StyleEntity setName(StyleName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StyleEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<SongEntity> getSongs() {
        return songs;
    }

    public StyleEntity setSongs(Set<SongEntity> songs) {
        this.songs = songs;
        return this;
    }
}
