package com.dalgee.elasticsearch.plugins.tokenizer;

import org.apache.lucene.analysis.Tokenizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class KoreanChosungTokenizerTest {
    private static final Tokenizer TOKENIZER = new KoreanChosungTokenizer();
    private static final Reader R;


    static {
        R = new StringReader("hahahah merong");
    }

    @Before
    public void setup() throws IOException {
        TOKENIZER.reset();
        TOKENIZER.setReader(R);
    }

    @Test
    public void test1() throws IOException {

        while(TOKENIZER.incrementToken()) {

        }

    }


    @After
    public void finish() throws IOException {
        TOKENIZER.close();
        R.close();
    }
}