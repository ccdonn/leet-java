package com.donn.leet;

public class P476 {

    public static void main(String[] args) {
        System.out.println(findComplement(1));
        System.out.println(0);
        System.out.println(~0);
    }

    public static int findComplement(int num) {
        int a = 1;
        int n = num;
        while (n > 0) {
            a = a << 1;
            n = n >> 1;
        }
        return num ^ a - 1;
        // return Integer.parseInt(ver(Integer.toBinaryString(num)), 2);
    }

    public static String ver(String in) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}
