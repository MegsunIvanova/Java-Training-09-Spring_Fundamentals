package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "languages")
@NamedEntityGraph(
        name = "languageWithWords",
        attributeNodes = @NamedAttributeNode("words")
)
public class LanguageEntity extends BaseEntity{

    //name: unique, not null
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private LanguageName name;

    //description: not null
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language", targetEntity = WordEntity.class)
    private Set<WordEntity> words;

    public LanguageEntity() {
        this.words = new HashSet<>();
    }

    public LanguageEntity(LanguageName name) {
        this();
        this.name = name;
        this.description = name.getDescription();
    }

    public LanguageName getName() {
        return name;
    }

    public LanguageEntity setName(LanguageName languageName) {
        this.name = languageName;
        this.description = languageName.getDescription();
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LanguageEntity setDescription(LanguageName languageName) {
        this.description = languageName.getDescription();
        return this;
    }

    public Set<WordEntity> getWords() {
        return words;
    }

    public LanguageEntity setWords(Set<WordEntity> words) {
        this.words = words;
        return this;
    }
}
