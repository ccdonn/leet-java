package com.donn.leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class P20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> q = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    q.push(c);
                    break;
                case ']':
                    if (q.isEmpty() || !q.pop().equals('[')) {
                        return false;
                    }
                    break;
                case ')':
                    if (q.isEmpty() || !q.pop().equals('(')) {
                        return false;
                    }
                    break;
                case '}':
                    if (q.isEmpty() || !q.pop().equals('{')) {
                        return false;
                    }
                    break;
            }
        }
        return q.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new P20().isValid("()"));
        System.out.println(new P20().isValid("()[]{}"));
        System.out.println(new P20().isValid("(]"));
        System.out.println(new P20().isValid("([)]"));
        System.out.println(new P20().isValid("{[]}"));
    }
}
