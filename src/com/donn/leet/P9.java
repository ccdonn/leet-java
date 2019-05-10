package com.donn.leet;

public class P9 {
    public static void main(String[] args) {
        System.out.println(new P9().isPalindrome(9));
        System.out.println(new P9().isPalindrome(121));
        System.out.println(new P9().isPalindrome(-121));
        System.out.println(new P9().isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        // 1.
        // String val = String.valueOf(;);
        // for (int i = 0; i < val.length(); i++) {
        // if (val.charAt(i) != val.charAt(val.length() - 1 - i)) {
        // return false;
        // }
        // }
        // return true;

        // 2.
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return sb.toString().equals(sb.reverse().toString());
    }
}
