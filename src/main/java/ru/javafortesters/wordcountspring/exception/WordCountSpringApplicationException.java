package ru.javafortesters.wordcountspring.exception;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCountSpringApplicationException extends IOException{

    public WordCountSpringApplicationException(String message, String className) {
        super(message);
        Logger.getLogger(
                className).log(Level.WARNING, message);
    }
}
