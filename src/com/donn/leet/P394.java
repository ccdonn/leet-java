package com.donn.leet;

import java.util.ArrayList;
import java.util.List;

public class P394 {

    public static void main(String[] args) {
        // System.out.println(decodeString("ab"));
        // System.out.println(decodeString("a2[b]"));
        // System.out.println(decodeString("3[ab]"));
        // System.out.println(decodeString("3[a2[c]]"));
        // System.out.println(decodeString("3[a2[c]b]"));
        // System.out.println(decodeString("3[a]b"));
        // System.out.println(decodeString("3[a]2[bc]"));
        // System.out.println(decodeString("2[2[y]pq4[2[jk]e1[f]]]"));
        System.out.println(decodeString("4[2[jk]e1[f]]"));

    }

    public static String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        findPatterns(s).forEach(v -> {
            sb.append(decode(v));
        });

        return sb.toString();
    }

    private static String decode(String s) {
        StringBuffer sb = new StringBuffer();
        StringBuffer tmp = new StringBuffer();
        int times = 0;
        int bracketsCounter = 0;
        boolean inBrackets = false;
        for (int i = 0; i < s.length(); i++) {
            if (!inBrackets && isDigit(s.charAt(i))) {
                times = times * 10 + (s.charAt(i) - 48);
            } else if (isStartBrackets(s.charAt(i))) {
                if (inBrackets) {
                    tmp.append(s.charAt(i));
                } else {
                    inBrackets = true;
                }
                bracketsCounter++;
            } else if (isEndBrackets(s.charAt(i))) {
                if (--bracketsCounter == 0) {
                    inBrackets = false;
                    sb.append(repeat(decodeString(tmp.toString()), times));
                } else {
                    tmp.append(s.charAt(i));
                }
            } else {
                if (inBrackets) {
                    tmp.append(s.charAt(i));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    /**
     * Samples: ab, a2[b], 3[ab], 3[a2[c]]
     * 
     * @param s
     * @return
     */
    private static List<String> findPatterns(String s) {

        List<String> res = new ArrayList<>();

        boolean isTimes = false;
        boolean inPattern = false;
        int beginIndex = -1;
        int endIndex = -1;
        int firstDigitIndex = -1;
        int bracketsCounter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isDigit(s.charAt(i))) {
                isTimes = true;
                if (firstDigitIndex == -1) {
                    if (inPattern) {
                        endIndex = i;
                        res.add(s.substring(beginIndex, endIndex));
                        inPattern = false;
                        firstDigitIndex = i;
                        beginIndex = i;
                        endIndex = -1;
                    } else {
                        firstDigitIndex = i;
                        beginIndex = i;
                    }
                } else {
                    // skip all digit, do nothing
                }
            } else if (isTimes && isStartBrackets(s.charAt(i))) {
                bracketsCounter++;
            } else if (isTimes && isEndBrackets(s.charAt(i))) {
                if (--bracketsCounter == 0) {
                    endIndex = i + 1;
                    res.add(s.substring(beginIndex, endIndex));
                    beginIndex = -1;
                    endIndex = -1;
                    inPattern = false;
                    isTimes = false;
                    firstDigitIndex = -1;
                }
            } else {
                if (inPattern) {
                    // do nothing
                    endIndex = i + 1;
                    if (endIndex == s.length()) {
                        res.add(s.substring(beginIndex, endIndex));
                        // inPattern = false;
                    }
                } else {
                    inPattern = true;
                    if (beginIndex == -1) {
                        beginIndex = i;
                    }
                    if (i == s.length() - 1) {
                        res.add(s.substring(beginIndex));
                    }
                }
            }
        }

        System.out.println(res);
        return res;

    }

    static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    static boolean isStartBrackets(char c) {
        return c == 91;
    }

    static boolean isEndBrackets(char c) {
        return c == 93;
    }

    static String repeat(String s, int times) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
