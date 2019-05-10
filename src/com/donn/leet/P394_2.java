package com.donn.leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class P394_2 {

    public static void main(String[] args) {
        // System.out.println(decodeString("ab"));
        // System.out.println(decodeString("a2[b]"));
        // System.out.println(decodeString("3[ab]"));
        // System.out.println(decodeString("3[a2[c]]"));
        // System.out.println(decodeString("3[a2[c]b]"));
        // System.out.println(decodeString("3[a]b"));
        // System.out.println(decodeString("3[a]2[bc]"));
        // System.out.println(decodeString("2[2[y]pq4[2[jk]e1[f]]]"));
        // System.out.println(decodeString("4[2[jk]e1[f]]"));

    }

    public static String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (isEndBrackets(s.charAt(i))) {
                StringBuffer sb = new StringBuffer();
                StringBuffer numberSb = new StringBuffer();
                while (!stack.isEmpty() && isAlphabet(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // pop '['
                while (!stack.isEmpty() && isDigit(stack.peek())) {
                    numberSb.insert(0, stack.pop());
                }
                for (char c : repeat(sb.toString(), Integer.parseInt(numberSb.toString())).toCharArray()) {
                    stack.push(c);
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    static boolean isAlphabet(char c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }

    static boolean isStartBrackets(char c) {
        return c == 91;
    }

    static boolean isEndBrackets(char c) {
        return c == 93;
    }

    static String repeat(String s, int times) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
