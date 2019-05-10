package com.donn.leet;

import java.util.HashSet;
import java.util.Set;

public class P459 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abac"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                if (fun(s, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean fun(String s, int i) {
        Set<String> set = new HashSet<>();
        int start = 0;
        while (start + i <= s.length()) {
            set.add(s.substring(start, start + i));
            start += i;
        }
        return set.size() == 1;
    }
}
