package com.dalgee.elasticsearch.plugins.analyzer;

import com.dalgee.elasticsearch.plugins.filters.KoreanChosungTokenFilter;
import com.dalgee.elasticsearch.plugins.filters.KoreanChosungTokenFilterFactory;
import com.dalgee.elasticsearch.plugins.tokenizer.KoreanChosungTokenizerFactory;
import org.apache.lucene.analysis.Analyzer;

import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

/**
 *
 */
public class KoreanChosungAnalyzerPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap("korean-chosung-analyzer", KoreanChosungAnalyzerProvider::new);
    }

//    @Override
//    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
//        return Collections.singletonMap("korean-chosung-tokenizer", KoreanChosungTokenizerFactory::new);
//    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return Collections.singletonMap("korean-chosung-tokenfilter", KoreanChosungTokenFilterFactory::new);
    }
}
