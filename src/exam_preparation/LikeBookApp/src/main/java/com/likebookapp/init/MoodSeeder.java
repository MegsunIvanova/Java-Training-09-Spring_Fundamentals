package com.likebookapp.init;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodName;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoodSeeder implements CommandLineRunner {

    private final MoodRepository moodRepository;

    public MoodSeeder(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (moodRepository.count() == 0) {
            List<MoodEntity> moods = Arrays.stream(MoodName.values())
                    .map(MoodEntity::new)
                    .collect(Collectors.toList());

            moodRepository.saveAll(moods);
        }
    }
}
