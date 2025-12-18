package com.mg.simpleBibleButton;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponce {

    @JsonProperty("random_verse")
    private Quote quote;

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
