package com.donn.leet;

public class P338 {
    public static void main(String[] args) {

    }

    public int[] countBits(int num) {
        int[] r = new int[num];
        for (int i = 0; i <= num; i++) {
            r[i] = Integer.bitCount(i);
        }
        return r;
    }

}
