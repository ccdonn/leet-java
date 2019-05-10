package com.donn.leet;

import java.util.Arrays;

public class P455 {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
        System.out.println(findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
        System.out.println(findContentChildren(new int[] { 10, 9, 8, 7 }, new int[] { 5, 6, 7, 8 }));
        System.out.println(findContentChildren(new int[] { 10, 9, 8, 7, 10, 9, 8, 7 }, new int[] { 10, 9, 8, 7 }));
    }

    public static int findContentChildren(int[] g, int[] s) {
        //
        // Set<Integer> interset = Arrays.stream(g.length > s.length ? s : g).boxed().collect(Collectors.toSet());
        // List<Integer> l1 = Arrays.stream(g).boxed().collect(Collectors.toList());
        // List<Integer> l2 = Arrays.stream(s).boxed().collect(Collectors.toList());
        //
        // interset.retainAll(g.length > s.length ? l1 : l2);
        // if (interset.size() > 0) {
        // l1.removeAll(interset);
        // g = l1.stream().mapToInt(i -> i).toArray();
        // l2.removeAll(interset);
        // s = l2.stream().mapToInt(i -> i).toArray();
        // }

        Arrays.sort(g); // child
        Arrays.sort(s); // cookie

        // Boolean[] b = new Boolean[g.length];
        // Arrays.fill(b, false);

        // for (int i = 0; i < g.length; i++) {
        // for (int j = 0; j < s.length; j++) {
        // if (s[j] == 0 || g[i] == 0) {
        // continue;
        // }
        // if (g[i] > s[j]) {
        // g[i] -= s[j];
        // s[j] = 0;
        // } else if (g[i] == s[j]) {
        // b[i] = true;
        // g[i] = 0;
        // s[j] = 0;
        // }
        // }
        // }

        // s: cookie
        // g: child
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[j] > 0 && s[i] >= g[j]) {
                    // b[j] = true;
                    count++;
                    g[j] = 0;
                    break;
                }
            }
        }

        // return (int) Arrays.stream(b).filter(v -> v).count();
        return count;
    }
}
