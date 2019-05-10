package com.donn.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P446 {

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        System.out.println(new P446().powerSet(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1)).size());
        System.out.println(System.currentTimeMillis() - t);

        t = System.currentTimeMillis();
        System.out.println(new P446().numberOfArithmeticSlices(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1 }));
        System.out.println(System.currentTimeMillis() - t);
    }

    public int numberOfArithmeticSlices(int[] A) {
        return (int) powerSet(Arrays.stream(A).mapToObj(i -> i).collect(Collectors.toList())).stream().parallel().filter(s -> isTarget(s)).count();
    }

    public boolean isTarget(List<Integer> set) {
        if (set.size() < 3) {
            return false;
        }

        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        int base = 0;
        boolean first = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (first) {
                base = list.get(i + 1) - list.get(i);
                first = false;
            } else {
                if (list.get(i + 1) - list.get(i) != base) {
                    return false;
                }
            }
        }
        return true;
    }

    public <T> List<List<T>> powerSet(List<T> originalSet) {
        List<List<T>> sets = new ArrayList<>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        List<T> rest = new ArrayList<T>(list.subList(1, list.size()));
        for (List<T> list2 : powerSet(rest)) {
            List<T> newList = new ArrayList<T>();
            newList.add(head);
            newList.addAll(list2);
            sets.add(newList);
            sets.add(list2);
        }
        return sets;
    }

    public void powerset(List<Integer> list) {

    }
}
