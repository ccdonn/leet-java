package com.donn.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.toMap(
            p -> {
                return p.chars().mapToObj(i -> new Character((char) i)).collect(Collectors.toMap(
                    v -> v,
                    v -> 1,
                    (Integer v1, Integer v2) -> {
                        return v1 + v2;
                    }));
            },
            p -> {
                List<String> l = new ArrayList<>();
                l.add(p);
                return l;
            }, (List<String> p1, List<String> p2) -> {
                p1.addAll(p2);
                return p1;
            })).values());

    }

    public static void main(String[] args) {
        System.out.println(new P49().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
