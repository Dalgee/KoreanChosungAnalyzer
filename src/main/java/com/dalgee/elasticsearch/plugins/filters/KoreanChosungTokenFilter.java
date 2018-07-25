package com.dalgee.elasticsearch.plugins.filters;

import com.dalgee.elasticsearch.plugins.common.Utils;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;



public final class KoreanChosungTokenFilter extends TokenFilter {
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);

    private char[] buffer;


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
        while(true) {
            if(buffer == null) {
                if(!input.incrementToken()) {
                    return false;
                }
                else {
                    buffer = termAtt.buffer().clone();

                    int end = 0;

                    for(int i=0; i<termAtt.length(); i++, end++) {
                        char ch = buffer[i];

                        if(ch == '\0')
                            break;

                        if(Utils.isHangul(ch)) {
                            buffer[i] = Utils.toChosung(ch);
                        }
                    }

                    termAtt.copyBuffer(buffer, 0, end);
                    termAtt.setLength(end);

                    return true;
                }
            }

            buffer = null;
        }
    }


}
