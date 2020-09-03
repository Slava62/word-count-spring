package ru.javafortesters.wordcountspring.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WordExtractor {

    public List<String> extractWords(String book) {
        String[] word=book.split("\\s+|\\W");
        //System.out.println(word.length);
        return Arrays.asList(word.clone());
    }
}
