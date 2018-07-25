package com.dalgee.elasticsearch.plugins.common;

public class Utils {

    private Utils() {
        throw new RuntimeException("do not instantiate");
    }

    public static boolean isHangul(char ch) {
        return ch >= 0xAC00 && ch <= 0xD7A3;
    }


    public static char toChosung(char hangul) {
        return (char)((((hangul - 0xAC00) / 28) / 21) + 0x1100);
    }


}
