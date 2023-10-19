package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.Style;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class StyleSeed implements CommandLineRunner {
    private final StyleRepository styleRepository;

    public StyleSeed(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (styleRepository.count() == 0) {
            styleRepository.saveAll(
                    Arrays.stream(StyleName.values())
                            .map(StyleEntity::new)
                            .collect(Collectors.toList())
            );
        }
    }
}
