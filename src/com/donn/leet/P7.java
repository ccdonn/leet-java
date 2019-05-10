package com.donn.leet;

import java.math.BigInteger;

public class P7 {
    public int reverse(int x) {

        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            sb.append(x).reverse();
        } else if (x < 0) {
            sb.append(x).deleteCharAt(0).reverse();
        }
        if (x < 0) {
            sb.insert(0, "-");
        }

        // overflow
        if (new BigInteger(sb.toString()).compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
            // overflow
            return 0;
        }
        if (new BigInteger(sb.toString()).compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
            // overflow
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new P7().reverse(0));
        System.out.println(new P7().reverse(123));
        System.out.println(new P7().reverse(-123));
        System.out.println(new P7().reverse(120));
        System.out.println(new P7().reverse(-2147483648));

    }
}
