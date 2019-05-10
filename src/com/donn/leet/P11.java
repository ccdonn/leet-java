package com.donn.leet;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P11 {
    public static void main(String[] args) {
        System.out.println(new P11().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(new P11().maxArea(new int[] { 1, 1, 1, 1, 1 }));
    }

    public int maxArea(int[] height) {
        Set<Integer> set = Arrays.stream(height).boxed().collect(Collectors.toSet());
        int max = 0;
        for (Integer i : set) {
            int ri = findRightIndex(height, i);
            int li = findLeftIndex(height, i);
            int area = i * (ri - li);
            // System.out.println(i + " * (" + ri + " - " + li + ") = " + area);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    public int findRightIndex(int[] h, int max) {
        for (int i = h.length - 1; i >= 0; i--) {
            if (h[i] >= max) {
                return i;
            }
        }
        return 0;
    }

    public int findLeftIndex(int[] h, int max) {
        for (int i = 0; i < h.length; i++) {
            if (h[i] >= max) {
                return i;
            }
        }
        return 0;
    }
}
