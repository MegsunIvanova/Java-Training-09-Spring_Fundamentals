package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.model.entity.WordEntity;

import java.time.LocalDate;

public class WordHomeDTO {
    private Long id;

    private String term;
    private String translation;

    private String example;

    private LocalDate inputDate;

    private String addedByUsername;

    public WordHomeDTO() {
    }

    public WordHomeDTO(WordEntity entity) {
        this.id = entity.getId();
        this.term = entity.getTerm();
        this.translation = entity.getTranslation();
        this.example = entity.getExample();
        this.inputDate = entity.getInputDate();
        this.addedByUsername = entity.getAddedBy().getUsername();
    }

    public Long getId() {
        return id;
    }

    public WordHomeDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public WordHomeDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordHomeDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordHomeDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public WordHomeDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getAddedByUsername() {
        return addedByUsername;
    }

    public WordHomeDTO setAddedByUsername(String addedByUsername) {
        this.addedByUsername = addedByUsername;
        return this;
    }
}
