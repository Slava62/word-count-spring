package ru.javafortesters.wordcountspring.model;

import java.io.Serializable;

public class Word implements Serializable {

    private String word;
    private Long count;

    public Word(String word, Long count) {
        this.word = word;
        this.count = count;
    }

}
