package com.donn.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * same as P49_2
 * 
 * @author donn.lin
 *
 */
public class P49_3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String s = String.valueOf(ca);

            if (m.get(s) == null) {
                m.put(s, new ArrayList<>());
            }
            m.get(s).add(str);
        }
        return new ArrayList<>(m.values());

    }

    public static void main(String[] args) {
        System.out.println(new P49_3().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
