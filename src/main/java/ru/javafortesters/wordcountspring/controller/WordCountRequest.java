package ru.javafortesters.wordcountspring.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class WordCountRequest implements Serializable{

    private Long idRequest;
    private String text;

}
