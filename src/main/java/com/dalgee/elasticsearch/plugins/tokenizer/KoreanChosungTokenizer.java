package com.dalgee.elasticsearch.plugins.tokenizer;

import org.apache.lucene.analysis.Tokenizer;

import java.io.IOException;

public class KoreanChosungTokenizer extends Tokenizer {
    @Override
    public boolean incrementToken() throws IOException {
        return false;
    }
}
