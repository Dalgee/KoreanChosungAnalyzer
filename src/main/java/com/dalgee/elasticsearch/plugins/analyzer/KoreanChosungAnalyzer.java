package com.dalgee.elasticsearch.plugins.analyzer;

import com.dalgee.elasticsearch.plugins.filters.KoreanChosungTokenFilter;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;

public class KoreanChosungAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer source = new WhitespaceTokenizer();

        return new TokenStreamComponents(source, new KoreanChosungTokenFilter(source));
    }
}
