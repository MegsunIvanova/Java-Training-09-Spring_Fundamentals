package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.dto.HomeViewDTO;

public interface WordService {
    boolean create(AddWordDTO wordDTO);

    HomeViewDTO generateHomeView();

    void removeWord(Long id);

    void removeAll();
}
