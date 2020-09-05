package ru.javafortesters.wordcountspring.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordCountService {


    public Map<String,Long> count(String book){

        String[] words=book.toLowerCase().split("\\s+|\\W+|\\d+");
        Map<String,Long> wordList=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty())
            {
                if(wordList.containsKey(words[i])){
                    Long count = wordList.get(words[i]);
                    wordList.put(words[i],count + 1);
                } else {
                    wordList.put(words[i], 1L);
                }
            }
        }
        return wordList;
    }

}
