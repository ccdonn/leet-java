package com.donn.leet;

public class P796 {
    public static void main(String[] args) {
        System.out.println(new P796().rotateString("abcde", "cdeab"));
        System.out.println(new P796().rotateString("abcde", "abced"));
    }

    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        for (int i = 0; i < A.length(); i++) {
            if ((A.substring(i) + A.substring(0, i)).equals(B)) {
                return true;
            }
        }
        return false;
    }
}
