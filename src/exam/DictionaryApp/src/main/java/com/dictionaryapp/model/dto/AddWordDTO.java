package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddWordDTO {

    @NotEmpty(message = "Term cannot be empty.")
    @Size(min = 2, max = 40, message = "Term must be between 2 and 40 characters.")
    private String term;

    @NotEmpty(message = "Translation cannot be empty.")
    @Size(min = 2, max = 80, message = "Translation must be between 2 and 40 characters.")
    private String translation;

    @Size(min = 2, max = 200, message = "Example must be between 2 and 40 characters.")
    private String example;

    @NotNull(message = "Please, set input date.")
    @PastOrPresent(message = "The date must be in the past or present.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputDate;

    @NotNull(message = "Please, select language.")
    private LanguageName language;

    public AddWordDTO() {
    }

    public String getTerm() {
        return term;
    }

    public AddWordDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public AddWordDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public AddWordDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public AddWordDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public LanguageName getLanguage() {
        return language;
    }

    public AddWordDTO setLanguage(LanguageName language) {
        this.language = language;
        return this;
    }
}
