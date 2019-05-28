package com.donn.leet;

public class P97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        while (true) {
            int sameLen = 0;
            if ((sameLen = sameStart(s1, s3)) > 0) {
                s1 = s1.substring(sameLen);
                s3 = s3.substring(sameLen);
            } else if ((sameLen = sameStart(s2, s3)) > 0) {
                s2 = s2.substring(sameLen);
                s3 = s3.substring(sameLen);
            } else {
                return false;
            }
            if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
                return true;
            }
        }
    }

    private int sameStart(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        System.out.println(new P97().sameStart("aabcc", "aabcc"));
        System.out.println(new P97().sameStart("aabcc", "aadbbcbcac"));
        System.out.println(new P97().sameStart("dbbca", "aadbbcbcac"));

        System.out.println(new P97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new P97().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
