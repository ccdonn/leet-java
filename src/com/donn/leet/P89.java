package com.donn.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P89 {
    public List<Integer> grayCode(int n) {
        List<Integer> r = new ArrayList<>();
        if (n == 0) {
            r.add(0);
            return r;
        } else if (n == 1) {
            r.add(0);
            r.add(1);
            return r;
        } else {
            r = grayCode(n - 1);
            List<Integer> t = new ArrayList<>();
            t.addAll(r);
            Collections.reverse(t);
            t = t.stream().map(v -> v + (1 << n - 1)).collect(Collectors.toList());
            r.addAll(t);
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new P89().grayCode(1));
        System.out.println(new P89().grayCode(2));
        System.out.println(new P89().grayCode(3));
        System.out.println(new P89().grayCode(4));
    }
}
