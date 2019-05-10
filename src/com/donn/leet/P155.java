package com.donn.leet;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class P155 {

    public static void main(String[] args) {
        P155 p = new P155();
        p.push(-2);
        p.push(0);
        p.push(-3);
        System.out.println(p.getMin());
        p.pop();
        System.out.println(p.top());
        System.out.println(p.getMin());
    }

    LinkedList<Integer> l;
    Map<Integer, Integer> map;

    public P155() {
        l = new LinkedList<>();
        map = new TreeMap<>();
    }

    public void push(int x) {
        l.addFirst(x);
        if (map.get(x) == null) {
            map.put(x, 1);
        } else {
            map.put(x, map.get(x) + 1);
        }
    }

    public void pop() {
        int i = l.removeFirst();
        if (map.get(i) == 1) {
            map.remove(i);
        } else {
            map.put(i, map.get(i) - 1);
        }
    }

    public int top() {
        return l.getFirst();
    }

    public int getMin() {
        Set<Integer> s = map.keySet();
        Integer[] a = new Integer[s.size()];
        s.toArray(a);
        return a[0];
    }
}
