package com.dalgee.elasticsearch.plugins.tokenizer;

import org.apache.lucene.analysis.Tokenizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class KoreanChosungTokenizerTest {
    private static final Tokenizer TOKENIZER = new KoreanChosungTokenizer();
    private static final Reader R;


    static {
        Reader r;

        try {
            r = new FileReader("src/test/resources/input1.txt");
        } catch (Exception e) {
            r = null;
        }

        R = r;
    }


    @Before
    public void setup() throws IOException {
        TOKENIZER.setReader(R);
        TOKENIZER.reset();
    }


    @Test
    public void test1() throws IOException {
        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("src/test/resources"));

        paths.forEach(p -> {
            try {
                Files.lines(p).forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });




        while(TOKENIZER.incrementToken()) {
            System.out.println("merong");
        }

    }


    @After
    public void finish() throws IOException {
        TOKENIZER.close();
        R.close();
    }
}