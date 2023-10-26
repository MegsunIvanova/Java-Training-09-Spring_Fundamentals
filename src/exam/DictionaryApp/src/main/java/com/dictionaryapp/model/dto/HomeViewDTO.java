package com.dictionaryapp.model.dto;

import java.util.ArrayList;
import java.util.List;

public class HomeViewDTO {

    private List<WordHomeDTO> germanWords;
    private List<WordHomeDTO> spanishWords;
    private List<WordHomeDTO> frenchWords;
    private List<WordHomeDTO> italianWords;

    public HomeViewDTO() {
        germanWords = new ArrayList<>();
        spanishWords = new ArrayList<>();
        frenchWords = new ArrayList<>();
        italianWords = new ArrayList<>();
    }

    public List<WordHomeDTO> getGermanWords() {
        return germanWords;
    }

    public HomeViewDTO setGermanWords(List<WordHomeDTO> germanWords) {
        this.germanWords = germanWords;
        return this;
    }

    public List<WordHomeDTO> getSpanishWords() {
        return spanishWords;
    }

    public HomeViewDTO setSpanishWords(List<WordHomeDTO> spanishWords) {
        this.spanishWords = spanishWords;
        return this;
    }

    public List<WordHomeDTO> getFrenchWords() {
        return frenchWords;
    }

    public HomeViewDTO setFrenchWords(List<WordHomeDTO> frenchWords) {
        this.frenchWords = frenchWords;
        return this;
    }

    public List<WordHomeDTO> getItalianWords() {
        return italianWords;
    }

    public HomeViewDTO setItalianWords(List<WordHomeDTO> italianWords) {
        this.italianWords = italianWords;
        return this;
    }

    public int getAllWordsCount() {
        return germanWords.size()
                + spanishWords.size()
                + frenchWords.size()
                + italianWords.size();
    }
}
