package com.mg.simpleBibleButton;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponce {

    @JsonProperty("random_verse")
    private Quote verse;

    public Quote getVerse() {
        return verse;
    }

    public void setVerse(Quote verse) {
        this.verse = verse;
    }
}
