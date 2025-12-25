package com.mg.simpleBibleButton;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

@Controller
public class ButtonController {

    private final RestClient restClient;

    public ButtonController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/print")
    public String buttonClicked(Model model) {
        String path = "https://bible-api.com/data/kjv/random/jhn";
        ApiResponce responce = restClient.get()
                .uri(path)
                .retrieve()
                .body(ApiResponce.class);
        Quote quote = responce.getQuote();

        model.addAttribute("quote", quote);
        return "fragments/quote :: quoteFragment";
    }

}
