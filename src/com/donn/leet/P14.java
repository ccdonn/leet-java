package com.donn.leet;

public class P14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "a", "b" }));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        for (int i = 1; i <= strs[0].length(); i++) {
            String v = strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].startsWith(v)) {
                    continue;
                }
                if (i == 1) {
                    return "";
                }
                return strs[0].substring(0, i - 1);
            }
        }

        return strs[0];
    }

    public static String longestCommonPrefix2(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        String minStr = null;
        for (String s : strs) {
            if (minLen > s.length()) {
                minLen = s.length();
                minStr = s;
            }
        }

        for (int i = 1; i <= minLen; i++) {
            String val = minStr.substring(0, i);
            for (String s : strs) {
                if (!s.startsWith(val)) {
                    if (i == 1) {
                        return "";
                    }
                    return minStr.substring(0, i - 1);
                }
            }
        }

        return minStr;
    }
}
