package com.dalgee.elasticsearch.plugins.tokenizer;

import com.dalgee.elasticsearch.plugins.analyzer.KoreanChosungAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


public class KoreanChosungTokenizerTest {
    private static final Tokenizer tokenizer = new KoreanChosungTokenizer();
    private static final Reader R;


    static {
        Reader r;

        try {
            r = new FileReader("src/test/resources/input1.txt");
        }
        catch (Exception e) {
            r = null;
        }

        R = r;
    }


    @Test
    public void setup() throws IOException {
        tokenizer.setReader(new StringReader("abcd efgh ijkl"));
        tokenizer.reset();

        CharTermAttribute term = tokenizer.addAttribute(CharTermAttribute.class);

        while(tokenizer.incrementToken()) {
            System.out.println(term.toString());
        }

    }


    @Test
    public void test1() throws IOException {


    }


    @After
    public void finish() throws IOException {
        R.close();
        tokenizer.close();
    }
}