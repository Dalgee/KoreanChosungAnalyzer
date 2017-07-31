package com.dalgee.elasticsearch.plugins.analyzer;

import com.dalgee.elasticsearch.plugins.filters.KoreanChosungTokenFilter;
import com.dalgee.elasticsearch.plugins.tokenizer.KoreanChosungTokenizer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

public class KoreanChosungAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer source = new KoreanChosungTokenizer();

        return new TokenStreamComponents(source, new KoreanChosungTokenFilter(source));
    }
}
