package ru.javafortesters.wordcountspring.controller;


import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class WordCountResponse implements Serializable {

    private Long idRequest;
    private Map<String,Long> mapCounts = new HashMap<>();
}
