package com.dalgee.elasticsearch.plugins.tokenizer;

import org.apache.lucene.analysis.CharacterUtils;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public final class KoreanChosungTokenizer extends Tokenizer {
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final CharacterUtils.CharacterBuffer ioBuffer = CharacterUtils.newCharacterBuffer(4192);
    private int index = 0;

    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();

        char[] buffer = termAtt.buffer();


        CharacterUtils.fill(ioBuffer, input);



        while(index < 3) {
            int size = ioBuffer.getLength();
            buffer = termAtt.resizeBuffer(size);

            System.arraycopy(ioBuffer.getBuffer(), 0, buffer, 0, ioBuffer.getLength());

            ioBuffer.reset();


            index++;
            termAtt.setLength(size);

            return true;
        }







        return false;
    }
}
