package com.donn.leet;

public class P6 {
    public static void main(String[] args) {
        System.out.println(new P6().convert("PAYPALISHIRING", 3));
        System.out.println(new P6().convert("PAYPALISHIRING", 4));
        System.out.println(new P6().convert("ABCDE", 2));

    }

    public String convert(String s, int numRows) {

        if (s.length() == 0 || numRows == 1) {
            return s;
        }

        // prepare
        int size = numRows * 2 - 2;
        int group = s.length() / size + (s.length() % size > 0 ? 1 : 0);

        // build table
        Character[][] t = new Character[group][size];
        for (int i = 0; i < s.length(); i++) {
            t[i / size][i % size] = s.charAt(i);
        }

        // get
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < group; i++) {
            sb.append(t[i][0]);
        }

        for (int j = 1, k = size - 1; j <= k; j++, k--) {
            for (int i = 0; i < group; i++) {
                if (t[i][j] != null) {
                    sb.append(t[i][j]);
                }
                if (k != j) {
                    if (t[i][k] != null) {
                        sb.append(t[i][k]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
