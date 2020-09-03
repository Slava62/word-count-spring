package ru.javafortesters.wordcountspring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordExtractorTest {

    private BufferedReader reader;
    private FileReader fileReader;
    private String inputFileName;
    private String stringData;


    WordExtractor wordExtractor;

    @BeforeEach
    public void setUp() throws Exception {
        inputFileName = ".\\Book.txt";
        String line = null;
        String ls = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(inputFileName);
            reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                    stringBuilder.append( line );
                    stringBuilder.append( ls );
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stringData = stringBuilder.toString();
       // System.out.println(stringBuilder.toString());
    }



    @Test
    void extractWordsTest() {
        wordExtractor = new WordExtractor();
       System.out.println(wordExtractor.extractWords(stringData));
      //  for (String s:wordExtractor.extractWords(stringData)
      //       ) {
      //      System.out.println(s);
      // }

    }

    @AfterEach
    public void tearDown() throws Exception {
        reader.close();
        fileReader.close();
    }
}