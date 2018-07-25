package com.dalgee.elasticsearch.plugins.analyzer;

import com.dalgee.elasticsearch.plugins.filters.KoreanChosungTokenFilter;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;

public class KoreanChosungAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer source = new WhitespaceTokenizer();

        return new TokenStreamComponents(source, new EdgeNGramTokenFilter(new KoreanChosungTokenFilter(source), 1, 5));
    }
}
