package ru.javafortesters.wordcountspring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WordExtractor {

    public List<String> extractWords(String book) {
        String[] words=book.split("^\\s+|\\W");
        List<String> wordList=new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                wordList.add(words[i]);
            }
        }
        return wordList;
    }
}
