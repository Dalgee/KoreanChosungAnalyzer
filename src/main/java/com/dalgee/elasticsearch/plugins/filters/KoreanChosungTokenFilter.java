package com.dalgee.elasticsearch.plugins.filters;

import com.dalgee.elasticsearch.plugins.core.Disassembler;
import org.apache.lucene.analysis.CharacterUtils;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.ngram.NGramTokenFilter;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.util.CharTokenizer;

import java.io.IOException;



public final class KoreanChosungTokenFilter extends TokenFilter {
    private static Disassembler disassembler;

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);

    private final CharacterUtils.CharacterBuffer ioBuffer = CharacterUtils.newCharacterBuffer(8192);


    /**
     * Construct a token stream filtering the given input.
     *
     * @param input
     */
    public KoreanChosungTokenFilter(TokenStream input) {
        super(input);
    }


    @Override
    public boolean incrementToken() throws IOException {















        return false;
    }
}
