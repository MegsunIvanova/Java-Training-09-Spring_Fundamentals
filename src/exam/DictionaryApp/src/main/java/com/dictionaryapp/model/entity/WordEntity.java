package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class WordEntity extends BaseEntity {

    //term: not null, must be between 2 and 40 characters (inclusive of 2 and 40).
    @Column(nullable = false)
    private String term;

    //translation: not null, must be between 2 and 80 characters (inclusive of 2 and 80).
    @Column(nullable = false)
    private String translation;

    //example: must be between 2 and 200 characters (inclusive of 2 and 200).
    @Column (columnDefinition = "TEXT")
    private String example;

    //date:  not null, must be a date in the past or present.
    @Column(name="input_date", nullable = false)
    private LocalDate inputDate;

    //language:  not null
    @ManyToOne(optional = false)
    private LanguageEntity language;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity addedBy;

    public WordEntity() {
    }

    public String getTerm() {
        return term;
    }

    public WordEntity setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordEntity setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordEntity setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public WordEntity setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public WordEntity setLanguage(LanguageEntity language) {
        this.language = language;
        return this;
    }

    public UserEntity getAddedBy() {
        return addedBy;
    }

    public WordEntity setAddedBy(UserEntity addedBy) {
        this.addedBy = addedBy;
        return this;
    }
}
