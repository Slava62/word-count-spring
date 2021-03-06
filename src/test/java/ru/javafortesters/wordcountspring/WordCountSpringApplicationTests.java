package ru.javafortesters.wordcountspring;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.javafortesters.wordcountspring.controller.WordCountRequest;
import ru.javafortesters.wordcountspring.exception.WordCountSpringApplicationException;
import ru.javafortesters.wordcountspring.service.WordCountService;

import java.io.*;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest
@AutoConfigureMockMvc
class WordCountSpringApplicationTests {

    private BufferedReader reader;
    private FileReader fileReader;
    private String stringData;

    @Autowired
    private MockMvc mvc;

    @Value("classpath:Book.txt")
    Resource book;

    @Autowired
    WordCountService wordCountService;

    @BeforeEach
    public void setUp() throws IOException {
        String inputFileName =book.getFile().getPath(); //".\\Book.txt";
        Logger.getLogger(
                this.getClass().getName()).log(Level.INFO, "Read test data from file " + inputFileName);
        String line;
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
            throw new WordCountSpringApplicationException(e.getMessage(),this.getClass().getName());
           // e.printStackTrace();
        }
        stringData = stringBuilder.toString();
        Logger.getLogger(
                this.getClass().getName()).log(Level.INFO, "Test data file's read successful");
    }

    @Test
    public void countWordTest () throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        WordCountRequest wordCountRequest =
                new WordCountRequest(1L,stringData);
        ResultActions result = mvc.perform(MockMvcRequestBuilders
                .post("/words/wordCount")
                .content(objectMapper.writerFor(WordCountRequest.class)
                        .writeValueAsString(wordCountRequest))
                .contentType("application/json")
        );
        result.andExpect(MockMvcResultMatchers.status().isOk());
        Logger.getLogger(
                this.getClass().getName()).log(Level.INFO, "Count word response status " +
        result.andReturn().getResponse().getStatus());
        writeResult(result.andReturn().getResponse().getContentAsString());
   }

    private void writeResult(String result) throws IOException {
        FileWriter fileWriter = new FileWriter("response.json");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write(result);
        bufferedWriter.close();
        fileWriter.close();

    }

    @AfterEach
    public void tearDown() throws WordCountSpringApplicationException {
        try {
            reader.close();
            fileReader.close();
        } catch (IOException e){
            throw new WordCountSpringApplicationException(e.getMessage(),this.getClass().getName());
        }
    }
}
