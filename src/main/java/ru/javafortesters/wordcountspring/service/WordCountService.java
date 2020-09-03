package ru.javafortesters.wordcountspring.service;

import org.springframework.stereotype.Service;
import ru.javafortesters.wordcountspring.model.Word;

import java.util.List;

@Service
public class WordCountService {
    private WordExtractor wordExtractor;
    private WordCounter wordCounter;

    public WordCountService(WordExtractor wordExtractor, WordCounter wordCounter) {
        this.wordExtractor = wordExtractor;
        this.wordCounter = wordCounter;
    }

    public List<Word> countWords(String book){
        List<String> strings=wordExtractor.extractWords(book);
        return null;
    }
}
