package com.donn.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P15 {
    public static void main(String[] args) {
        new P15().threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> map = new HashMap<>();

        int[][] tmp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                tmp[i][j] = nums[i] + nums[j];
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    for (int k = 0; k < nums.length; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        if (tmp[i][j] + nums[k] == 0) {

                            int[] c = new int[] { nums[i], nums[j], nums[k] };
                            Arrays.sort(c);
                            List<Integer> r = Arrays.asList(c[0], c[1], c[2]);
                            String key = c[0] + "," + c[1] + "," + c[2];
                            if (map.get(key) == null) {
                                map.put(key, r);
                            }
                        }
                    }
                }
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

}
