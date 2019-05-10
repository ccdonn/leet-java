package com.donn.leet;

public class P1021 {

    public static void main(String[] args) {
        System.out.println(new P1021().removeOuterParentheses("(()())(())"));
        System.out.println(new P1021().removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(new P1021().removeOuterParentheses("()()"));

    }

    public String removeOuterParentheses(String S) {
        int r = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                r++;
                if (r == 1) {
                } else {
                    sb.append(c);
                }
            } else { // c == ')'
                r--;
                if (r == 0) {
                } else {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }

}
