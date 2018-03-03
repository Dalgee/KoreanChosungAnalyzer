package com.dalgee.elasticsearch.plugins.analyzer;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;

public class KoreanChosungAnalyzerProvider extends AbstractIndexAnalyzerProvider<KoreanChosungAnalyzer> {

    public KoreanChosungAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public KoreanChosungAnalyzer get() {
        return new KoreanChosungAnalyzer();
    }
}