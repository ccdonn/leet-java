package com.donn.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> m = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : str.toCharArray()) {
                if (map.get(c) == null) {
                    map.put(c, 0);
                }
                map.put(c, map.get(c) + 1);
            }

            if (m.get(map) == null) {
                m.put(map, new ArrayList<>());
            }
            m.get(map).add(str);
        }
        return new ArrayList<>(m.values());
    }

    public static void main(String[] args) {
        System.out.println(new P49_2().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
