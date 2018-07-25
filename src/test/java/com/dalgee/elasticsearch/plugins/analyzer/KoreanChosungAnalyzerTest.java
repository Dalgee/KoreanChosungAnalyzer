package com.dalgee.elasticsearch.plugins.analyzer;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class KoreanChosungAnalyzerTest {
    private KoreanChosungAnalyzer analyzer = new KoreanChosungAnalyzer();


    @Test
    public void test01() throws IOException {
        Reader reader = Files.asCharSource(new File("src/test/resources/input1.txt"), Charsets.UTF_8).openStream();

        TokenStream tokenStream = analyzer.tokenStream("field01", reader);

        CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();

        while(tokenStream.incrementToken()) {
            System.out.println(termAttribute.toString());
        }
    }
}