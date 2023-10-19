package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity, Long> {
    Optional<StyleEntity> findByName(StyleName styleName);

    @EntityGraph(value = "styleWithSongs", attributePaths = "songs")
    @Query("SELECT s FROM StyleEntity s ")
    List<StyleEntity> findAllStylesWithSongs();
}
