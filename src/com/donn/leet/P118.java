package com.donn.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P118 {

    private int cnr(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        } else if (r == 1 || r == n - 1) {
            return n;
        }

        long val = 1;
        for (int i = r; i > 0; i--, n--) {
            val *= n;
        }
        long val2 = 1;
        for (int i = 1; i <= r; i++) {
            val2 *= i;
        }
        return (int) (val / val2);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1));
        if (numRows == 0) {
            return Collections.emptyList();
        } else if (numRows == 1) {
            return r;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i / 2; j++) {
                list.add(cnr(i, j));
            }

            List<Integer> rv = new ArrayList<>();
            rv.addAll(list);
            Collections.reverse(rv);
            if (i % 2 == 0) {
                rv.remove(0);
            }
            list.addAll(rv);

            r.add(list);
        }
        return r;
    }

    public static void main(String[] args) {
        // new P118().cnr(5, 3);
        System.out.println(new P118().generate(15));

        System.out.println(new P118().generate(0));
        System.out.println(new P118().generate(1));
        System.out.println(new P118().generate(2));
    }

}
