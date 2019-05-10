package com.donn.leet;

public class P3 {
    public static void main(String[] args) {
        System.out.println(new P3().lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = -1;
            if ((index = sb.indexOf(Character.toString(c))) > -1) {
                if (sb.length() > max) {
                    max = sb.length();
                }
                sb.delete(0, index + 1);
            }
            sb.append(c);
        }
        if (sb.length() > max) {
            max = sb.length();
        }
        return max;
    }
}
