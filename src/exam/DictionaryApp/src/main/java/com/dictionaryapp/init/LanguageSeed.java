package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LanguageSeed implements CommandLineRunner {
    private final LanguageRepository languageRepository;

    public LanguageSeed(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (languageRepository.count() == 0) {
            List<LanguageEntity> languages = Arrays
                    .stream(LanguageName.values())
                    .map(LanguageEntity::new)
                    .collect(Collectors.toList());

            languageRepository.saveAll(languages);
        }
    }
}
