package com.dalgee.elasticsearch.plugins.tokenizer;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

public class KoreanChosungTokenizerFactory extends AbstractTokenizerFactory {

    public KoreanChosungTokenizerFactory(IndexSettings indexSettings, Environment env, String ignored, Settings settings) {
        super(indexSettings, ignored, settings);
    }

    @Override
    public Tokenizer create() {
        return new KoreanChosungTokenizer();
    }
}