package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.dto.HomeViewDTO;
import com.dictionaryapp.model.dto.WordHomeDTO;
import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.model.entity.WordEntity;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {
    private final ModelMapper modelMapper;
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;
    private final LoggedUser loggedUser;

    public WordServiceImpl(ModelMapper modelMapper, WordRepository wordRepository, UserRepository userRepository, LanguageRepository languageRepository, LoggedUser loggedUser) {
        this.modelMapper = modelMapper;
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.languageRepository = languageRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean create(AddWordDTO wordDTO) {
        WordEntity wordEntity = modelMapper.map(wordDTO, WordEntity.class);
        UserEntity addedBy = userRepository.findByUsername(loggedUser.getUsername()).orElse(null);

        LanguageEntity language = languageRepository.findByName(wordDTO.getLanguage()).orElse(null);

        if (addedBy == null || language == null) {
            return false;
        }

        wordEntity.setAddedBy(addedBy);
        wordEntity.setLanguage(language);

        wordRepository.save(wordEntity);

        return true;
    }

    @Override
    @Transactional
    public HomeViewDTO generateHomeView() {

        Map<String, List<WordHomeDTO>> wordsByLanguages = languageRepository
                .languagesWithWords()
                .stream()
                .collect(Collectors.toMap(
                        l -> l.getName().name(),
                        l -> mapToWordHomeDTOs(l.getWords())
                ));


        return new HomeViewDTO()
                .setGermanWords(wordsByLanguages.get(LanguageName.GERMAN.name()))
                .setFrenchWords(wordsByLanguages.get(LanguageName.FRENCH.name()))
                .setSpanishWords(wordsByLanguages.get(LanguageName.SPANISH.name()))
                .setItalianWords(wordsByLanguages.get(LanguageName.ITALIAN.name()));
    }

    @Override
    public void removeWord(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }

    private List<WordHomeDTO> mapToWordHomeDTOs(Set<WordEntity> words) {
        return words
                .stream()
                .map(WordHomeDTO::new)
                .collect(Collectors.toList());
    }
}
