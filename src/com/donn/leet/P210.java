package com.donn.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P210 {
    public static void main(String[] args) {

        int[] c1 = new int[2];
        int[] c2 = new int[4];
        int[] c3 = new int[2];
        int[] c4 = new int[3];
        int[] c5 = new int[7];

        c1 = findOrder(2, new int[][] { { 1, 0 } });
        c2 = findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        c3 = findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } });
        c4 = findOrder(3, new int[][] { { 1, 0 }, { 0, 2 }, { 2, 1 } });
        c4 = findOrder(3, new int[][] { { 1, 0 }, { 0, 2 }, { 2, 1 } });
        c5 = findOrder(7, new int[][] { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, { 2, 5 }, { 4, 5 }, { 5, 6 }, { 2, 4 } });

        // for (int i : c1) {
        // System.out.println(i);
        // }

        // for (int i : c2) {
        // System.out.println(i);
        // }

        // for (int i : c3) {
        // System.out.println(i);
        // }

        // for (int i : c4) {
        // System.out.println(i);
        // }

        for (int i : c5) {
            System.out.println(i);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Integer[] cs = IntStream.range(0, numCourses).mapToObj(i -> i).toArray(Integer[]::new);

        if (prerequisites.length == 0) {
            return Arrays.stream(cs).mapToInt(i -> i).toArray();
        }

        // build map
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] v : prerequisites) {
            if (map.get(v[1]) != null) {
                if (map.get(v[1]).contains(v[0])) {
                    return new int[] {};
                }
            }

            if (map.get(v[0]) == null) {
                map.put(v[0], new HashSet<>());

            }
            map.get(v[0]).add(v[1]);
        }

        if (map.values().stream().flatMap(Set::stream).distinct().collect(Collectors.toSet()).containsAll(map.keySet())) {
            return new int[] {};
        }

        Comparator c = Comparator.comparing(i -> i, (i1, i2) -> {
            if (map.get(i2) != null) {
                if (map.get(i2).contains(i1)) {
                    return -1;
                }
            }
            return 0;
        });

        Arrays.sort(cs, c);

        return Arrays.stream(cs).mapToInt(i -> i).toArray();
    }
}
