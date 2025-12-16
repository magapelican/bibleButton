package com.mg.simpleBibleButton;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ButtonController {

    private final RestTemplate restTemplate;

    public ButtonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/print")
    public String buttonClicked(Model model) {
        String path = "https://bible-api.com/data/kjv/random/jhn";
        ApiResponce responce = restTemplate.getForObject(path, ApiResponce.class);
        Quote quote = responce.getVerse();

        model.addAttribute("quote", quote);
        return "index";
    }

}
