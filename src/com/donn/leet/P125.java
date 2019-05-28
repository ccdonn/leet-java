package com.donn.leet;

public class P125 {
    public static void main(String[] args) {
        System.out.println(new P125().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new P125().isPalindrome("race a car"));
        System.out.println(new P125().isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}
