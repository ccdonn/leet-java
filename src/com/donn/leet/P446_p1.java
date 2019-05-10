package com.donn.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P446_p1 {
    public static void main(String[] args) {
        // System.out.println(new P446_p1().powerSet(Arrays.asList(2, 2, 3, 4)).size());
        // System.out.println(new P446_p1().powerSet(Arrays.asList(2, 2, 3, 4)));
        // System.out.println(new P446_p1().powerSet(Arrays.asList(2, 2, 3, 4)).stream().filter(v -> v.size() >
        // 2).collect(Collectors.toList()));

        // System.out.println(new P446_p1().powerSet2(Arrays.asList(2, 2, 3, 4)).size());
        System.out.println(new P446_p1().powerSet2(Arrays.asList(2, 2, 3, 4)));
        // System.out.println(new P446_p1().powerSet2(Arrays.asList(2, 2, 3, 4)).stream().filter(v -> v.size() >
        // 2).collect(Collectors.toList()));

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());

        list.add(Arrays.asList(2));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(4));

        list.add(Arrays.asList(2, 2));
        list.add(Arrays.asList(2, 3));
        list.add(Arrays.asList(2, 4));
        list.add(Arrays.asList(2, 3));
        list.add(Arrays.asList(2, 4));
        list.add(Arrays.asList(3, 4));

        list.add(Arrays.asList(2, 2, 3));
        list.add(Arrays.asList(2, 2, 4));
        list.add(Arrays.asList(2, 3, 4));
        list.add(Arrays.asList(2, 3, 4));

        list.add(Arrays.asList(2, 2, 3, 4));

        // System.out.println(list.size());
        //
        // System.out.println(list);
        //
        // System.out.println(list.stream().filter(v -> v.size() > 2).collect(Collectors.toList()));
        //
        // System.out.println("=====");
        //
        // System.out.println(new P446_p1().powerSet2(Arrays.asList(2, 2, 3, 4)));

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
        // return sets
        // .stream()
        // // .filter(v -> v.size() > 2)
        // .filter(v -> {
        // System.out.println(v.size());
        // if (v.size() > 2) {
        // System.out.println(v.size() + ", " + (v.size() > 2));
        // }
        // return true;
        // })
        // .collect(Collectors.toList());

        return sets;
    }

    public <T> List<List<T>> powerSet2(List<T> originalSet) {
        List<List<T>> sets = new ArrayList<>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        List<T> rest = new ArrayList<T>(list.subList(1, list.size()));
        for (List<T> list2 : powerSet2(rest)) {
            List<T> newList = new ArrayList<T>();
            newList.add(head);
            newList.addAll(list2);
            sets.add(newList);
            sets.add(list2);
        }
        return sets;
    }
}
