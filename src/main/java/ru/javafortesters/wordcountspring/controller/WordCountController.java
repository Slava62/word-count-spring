package ru.javafortesters.wordcountspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javafortesters.wordcountspring.service.WordCountService;

@RestController
@RequestMapping("/words")
@AllArgsConstructor

public class WordCountController {

    private final WordCountService wordCountService;


    //@GetMapping(value ="/")

    @PostMapping("/wordCount")
    public WordCountResponse countWord(@RequestBody WordCountRequest wordCountRequest){
       WordCountResponse wordCountResponse = new WordCountResponse();
       wordCountResponse.setIdRequest(wordCountRequest.getIdRequest());
       wordCountResponse.setMapCounts
                (wordCountService.count(wordCountRequest.getText()));

       return wordCountResponse;
    }

}