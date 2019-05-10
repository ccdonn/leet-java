package com.donn.leet;

import java.util.HashMap;
import java.util.Map;

public class P893 {
    public static void main(String[] args) {
        System.out.println(new P893().numSpecialEquivGroups(new String[] { "a", "b", "c", "a", "c", "c" }));
        System.out.println(new P893().numSpecialEquivGroups(new String[] { "aa", "bb", "ab", "ba" }));
        System.out.println(new P893().numSpecialEquivGroups(new String[] { "abc", "acb", "bac", "bca", "cab", "cba" }));
        System.out.println(new P893().numSpecialEquivGroups(new String[] { "abcd", "cdab", "adcb", "cbad" }));

        System.out.println(new P893().numSpecialEquivGroups(new String[] { "ababaa", "aaabaa" }));
    }

    public int numSpecialEquivGroups(String[] A) {
        Map<Map<Integer, Map<Character, Integer>>, Integer> total = new HashMap<>();
        for (String str : A) {
            Map<Integer, Map<Character, Integer>> map = build(str);
            if (total.get(map) != null) {
                total.put(map, total.get(map) + 1);
            } else {
                total.put(map, 1);
            }
        }
        return total.size();
    }

    private Map<Integer, Map<Character, Integer>> build(String str) {
        Map<Character, Integer> odd = new HashMap<>();
        Map<Character, Integer> even = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i % 2 == 0) {
                if (even.containsKey(c)) {
                    even.put(c, even.get(c) + 1);
                } else {
                    even.put(c, 1);
                }
            } else {
                if (odd.containsKey(c)) {
                    odd.put(c, odd.get(c) + 1);
                } else {
                    odd.put(c, 1);
                }
            }
        }
        Map<Integer, Map<Character, Integer>> r = new HashMap<>();
        r.put(1, odd);
        r.put(0, even);
        return r;
    }
}
