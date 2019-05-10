package com.donn.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P500 {

    public static void main(String[] args) {
        new P500().findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" });
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();

        for (String s : words) {
            if (judge(s)) {
                list.add(s);
            }
        }

        return list.stream().toArray(String[]::new);
    }

    Set<String> group1 = new HashSet<>(Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l"));
    Set<String> group2 = new HashSet<>(Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"));
    Set<String> group3 = new HashSet<>(Arrays.asList("z", "x", "c", "v", "b", "n", "m"));
    Set<String> group0 = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));

    private boolean judge(String s) {
        Set<String> gs = Arrays.stream(s.toLowerCase().split("")).collect(Collectors.toSet());
        if (group0.containsAll(gs)) {
            return true;
        }
        if (group1.containsAll(gs)) {
            return true;
        }
        if (group2.containsAll(gs)) {
            return true;
        }
        if (group3.containsAll(gs)) {
            return true;
        }

        return false;
    }
}
