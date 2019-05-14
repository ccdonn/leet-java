package com.donn.leet;

import java.util.LinkedList;
import java.util.List;

public class P60 {
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        k--;
        int f = n - 1;
        // List<Integer> order = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        List<Integer> order = buildList(n);

        StringBuilder sb = new StringBuilder();
        while (order.size() > 1) {
            if (order.size() == 2) {
                if (k == 0) {
                    sb.append(order.get(0)).append(order.get(1));
                } else {
                    sb.append(order.get(1)).append(order.get(0));
                }
                break;
            }
            int fr = factor(f--);
            sb.append(order.get(k / fr));
            order.remove(k / fr);
            k = k % fr;
        }

        return sb.toString();
    }

    private List<Integer> buildList(int n) {
        List<Integer> l = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            l.add(i);
        }
        return l;
    }

    private int factor(int i) {
        int r = 1;
        for (int k = 1; k <= i; k++) {
            r *= k;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new P60().getPermutation(1, 1));
        System.out.println(new P60().getPermutation(2, 1));
        System.out.println(new P60().getPermutation(3, 3));
        System.out.println(new P60().getPermutation(4, 9));
    }
}
