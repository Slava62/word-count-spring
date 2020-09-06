package ru.javafortesters.wordcountspring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class WordCountServiceTest {

    private BufferedReader reader;
    private FileReader fileReader;
    private String inputFileName;
    private String stringData;




    @BeforeEach
    public void setUp() throws Exception {
        inputFileName = "./src/test/resources/book.txt";
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
    public void wordCountServiceTest(){
        WordCountService wordCountService=new WordCountService();
        Map<String,Long> words= wordCountService.count(stringData);
        // \W+t\s|\W+t\W "t" - 9 times in book.txt
        assertEquals(9L, words.get("t"));
    }


    @AfterEach
    public void tearDown() throws Exception {
        reader.close();
        fileReader.close();
    }
}