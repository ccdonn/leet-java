package com.donn.leet;

import java.util.HashMap;
import java.util.Map;

public class P136 {

    public static void main(String[] args) {
        // singleNumber
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, i);
            }
        }

        return 0;
    }
}
