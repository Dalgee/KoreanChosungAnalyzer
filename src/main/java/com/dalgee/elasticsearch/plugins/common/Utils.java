package com.dalgee.elasticsearch.plugins.common;

public class Utils {

    private Utils() {

    }

    public static boolean isHangul(char ch) {
        return ch >= 0xAC00 && ch <= 0xD7A3;
    }

    public static boolean isWhitespace(char ch) {
        return Character.isWhitespace(ch);
    }


}
