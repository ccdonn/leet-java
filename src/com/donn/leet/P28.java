package com.donn.leet;

public class P28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        if (haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new P28().strStr("hello", "ll"));
        System.out.println(new P28().strStr("aaaaa", "bba"));
        System.out.println(new P28().strStr("a", "a"));
        System.out.println(new P28().strStr("mississippi", "pi"));
    }
}
