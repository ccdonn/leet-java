package com.donn.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author donn.lin
 *
 */
public class P49_4 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (Character c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i : count) {
                sb.append(i);
            }
            String key = sb.toString();
            if (m.get(key) == null) {
                m.put(key, new ArrayList<>());
            }
            m.get(key).add(str);
        }
        return new ArrayList<>(m.values());
    }

    public static void main(String[] args) {
        System.out.println(new P49_4().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
