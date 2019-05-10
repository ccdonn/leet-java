package com.donn.leet;

public class P5 {

    public String longestPalindrome(String s) {
        // String maxStr = null;
        // boolean[][] table = new boolean[s.length()][s.length()];
        // for (int i = s.length() - 1; i >= 0; i--) {
        // for (int j = i; j < s.length(); j++) {
        // table[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || table[i + 1][j - 1]);
        // if (table[i][j] && (maxStr == null || j - i + 1 > maxStr.length())) {
        // maxStr = s.substring(i, j + 1);
        // }
        // }
        // }
        // return maxStr;

        String maxStr = "";
        boolean[][] t = new boolean[s.length()][s.length()];
        for (int len = 0; len < s.length(); len++) {
            for (int start = 0; start + len < s.length(); start++) {
                // s.substring(start, start + len); // i = start, j = start+len
                if (len == 0) {
                    t[start][start + len] = true;
                } else if (len == 1) {
                    t[start][start + len] = s.charAt(start) == s.charAt(start + len);
                } else {
                    t[start][start + len] = s.charAt(start) == s.charAt(start + len) && t[start + 1][start + len - 1];
                }

                if (t[start][start + len] && len + 1 > maxStr.length()) {
                    maxStr = s.substring(start, start + len + 1);
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(new P5().longestPalindrome("a"));
        System.out.println(new P5().longestPalindrome("ba"));
        System.out.println(new P5().longestPalindrome("babac"));
        System.out.println(new P5().longestPalindrome("cbbd"));
        System.out.println(new P5().longestPalindrome("aaaa"));
    }
}
