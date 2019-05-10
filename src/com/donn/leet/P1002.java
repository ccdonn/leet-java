package com.donn.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P1002 {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[] { "bella", "label", "roller" }));
    }

    public static List<String> commonChars(String[] A) {
        Map<String, Integer> map = new HashMap<>();
        for (char c : A[0].toCharArray()) {
            map.put("" + c, map.getOrDefault("" + c, 0) + 1);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i < A.length; i++) {
            map2.clear();
            for (char c : A[i].toCharArray()) {
                map2.put("" + c, map2.getOrDefault("" + c, 0) + 1);
            }

            Set<String> intersec = map.keySet();
            intersec.retainAll(map2.keySet());

            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> e = it.next();
                if (intersec.contains(e.getKey())) {
                    if (e.getValue() > map2.get(e.getKey())) {
                        e.setValue(map2.get(e.getKey()));
                    }
                } else {
                    it.remove();
                }
            }
        }

        List<String> r = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                r.add(entry.getKey());
            }
        }
        return r;
    }
}
