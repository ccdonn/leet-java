package com.donn.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        if (nums.length == 1) {
            r.add(Arrays.asList(nums[0]));
            return r;
        }
        if (nums.length == 2) {
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            l1.add(nums[0]);
            l1.add(nums[1]);
            l2.add(nums[1]);
            l2.add(nums[0]);
            r.add(l1);
            r.add(l2);
            return r;
        }
        // if (nums.length > 2)
        List<List<Integer>> p = permute(Arrays.copyOf(nums, nums.length - 1));

        p.forEach(v -> {
            for (int i = 0; i <= v.size(); i++) {
                // v.add(i, nums[nums.length - 1]);
                v.add(i, nums[nums.length - 1]);
                r.add(new ArrayList<>(v));
                v.remove(i);
            }
        });

        return r;

    }

    public static void main(String[] args) {
        System.out.println(new P46().permute(new int[] { 1 }));
        System.out.println(new P46().permute(new int[] { 1, 2 }));
        System.out.println(new P46().permute(new int[] { 1, 2, 3 }));
        System.out.println(new P46().permute(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
    }
}
