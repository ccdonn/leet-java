package com.donn.leet;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

public class P42_2 {
    public static void main(String[] args) {
        // System.out.println(trap(new int[] { 5, 1, 2 })); // 1
        // System.out.println(trap(new int[] { 5, 4, 1, 2 })); // 1
        // System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })); // 6
        // System.out.println(trap(new int[] { 5, 1, 3, 1, 5, 1, 5, 1, 2 }));// 15
        // System.out.println(trap(new int[] { 2, 1, 0, 0, 1 }));// 2
        // System.out.println(trap(new int[] { 1, 0, 0, 1, 2 }));// 2
        // System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));// 9
        System.out.println(trap(new int[] { 9, 6, 8, 8, 5, 6, 3 }));// 2
        // foo(new ArrayList<>());
        // foo(new LinkedList<>());
    }

    public static int trap(int[] height) {

        // step1 : find max
        Map.Entry<Integer, Integer> entity = findMaxPair(height);
        Map.Entry<Integer, Integer> leftEntity =
            entity.getKey() == 0 ? findMaxPair(Arrays.copyOfRange(height, 0, entity.getKey() - 1)) : new AbstractMap.SimpleEntry<Integer, Integer>(null, 0);
        Map.Entry<Integer, Integer> rightEntity =
            entity.getKey() == height.length - 1 ? findMaxPair(Arrays.copyOfRange(height, entity.getKey() + 1, height.length)) : new AbstractMap.SimpleEntry<Integer, Integer>(null,
                0);

        if (leftEntity.getKey() == null || leftEntity.getKey() == 0) {
            // none
            return 0;
        }

        if (leftEntity.getKey() == null || rightEntity.getKey() == 0) {
            // none
            return 0;
        }

        // Map.Entry<Integer, Integer> leftMinEntity = findMinPair(Arrays.copyOfRange(height, leftEntity.getKey(),
        // entity.getKey()));
        // Map.Entry<Integer, Integer> rightMinEntity = findMinPair(Arrays.copyOfRange(height, entity.getKey(),
        // rightEntity.getKey()));

        int occu = 0;
        for (int i = leftEntity == null ? 0 : leftEntity.getKey(); i <= entity.getKey(); i++) {
            occu += height[i];
        }
        for (int i = entity.getKey(); i <= rightEntity.getKey(); i++) {
            occu += height[i];
        }

         leftEntity.getValue() * (entity.getKey() - leftEntity.getKey()) - occu ;
            trap(Arrays.copyOfRange(height, 0, leftEntity.getKey())) +
            trap(Arrays.copyOfRange(height, rightEntity.getKey(), height.length - 1));

         return 0;

    }

    private static Map.Entry<Integer, Integer> findMinPair(int[] height) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < height.length; i++) {
            if (height[i] < minValue) {
                minIndex = i;
                minValue = height[i];
            }
        }
        return new AbstractMap.SimpleEntry<Integer, Integer>(minIndex, height[minIndex]);
    }

    private static Map.Entry<Integer, Integer> findMaxPair(int[] height) {
        int maxIndex = -1;
        int maxValue = -1;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxValue) {
                maxIndex = i;
                maxValue = height[i];
            }
        }
        return new AbstractMap.SimpleEntry<Integer, Integer>(maxIndex, height[maxIndex]);
    }
}
