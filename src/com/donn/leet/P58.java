package com.donn.leet;

public class P58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - (s.lastIndexOf(" ") + 1);
    }

    public static void main(String[] args) {
        System.out.println(new P58().lengthOfLastWord("HELLO WORLD"));
        System.out.println(new P58().lengthOfLastWord("a "));
        System.out.println(new P58().lengthOfLastWord("a"));
        System.out.println(new P58().lengthOfLastWord(" "));
    }
}
