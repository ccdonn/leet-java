package com.donn.leet;

public class P387 {
    public static void main(String[] args) {
        System.out.println(new P387().firstUniqChar("leetcode"));
        System.out.println(new P387().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
