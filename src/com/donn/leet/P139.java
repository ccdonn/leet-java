package com.donn.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P139 {
    public static void main(String[] args) {
        System.out.println(new P139().wordBreak("applepenapple", Arrays.asList(new String[] { "apple", "pen" })));
        System.out.println(new P139().wordBreak("catsandog", Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat"
        })));
        System.out.println(new P139().wordBreak("aaaaaaaa", Arrays.asList(new String[] { "aaaa", "aa", "a" })));

        System.out.println(new P139().wordBreak(
            "aaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            Arrays.asList(new String[] { "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa", "ba" })));

        System.out.println(new P139().wordBreak(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            Arrays.asList(new String[] { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa" })));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

    private List<String> startWithAny(String s, List<String> wordDict) {
        return wordDict.stream().filter(v -> s.startsWith(v)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    private boolean containsAny(String s, List<String> wordDict) {
        return wordDict.stream().filter(v -> s.contains(v)).count() > 0;
    }
}
