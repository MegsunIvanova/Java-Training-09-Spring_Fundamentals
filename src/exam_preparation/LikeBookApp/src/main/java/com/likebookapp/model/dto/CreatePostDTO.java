package com.likebookapp.model.dto;

import com.likebookapp.model.enums.MoodName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePostDTO {
    @NotEmpty (message = "Content cannot be empty!")
    @Size(min=2, max =50, message = "Content length must be between 2 and 50 characters!")
    private String content;

    @NotNull(message = "You must select mood!")
    private MoodName mood;

    public CreatePostDTO() {
    }

    public String getContent() {
        return content;
    }

    public CreatePostDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public MoodName getMood() {
        return mood;
    }

    public CreatePostDTO setMood(MoodName mood) {
        this.mood = mood;
        return this;
    }
}
