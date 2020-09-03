package ru.javafortesters.wordcountspring.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.javafortesters.wordcountspring.service.WordCountService;

@RestController
public class WordCountController {
    private WordCountService wordCountService;

    public WordCountController(WordCountService wordCountService) {
        this.wordCountService = wordCountService;
    }

    public void WordCountRequest(String request){

    }
}