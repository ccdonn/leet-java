package com.donn.leet;

public class P190 {
    public static void main(String[] args) {
        // System.out.println(Integer.parseUnsignedInt("00000010100101000001111010011100", 2));
        System.out.println(go(43261596));
    }

    static int go(int n) {
        // System.out.println(n);
        // System.out.println(Integer.toBinaryString(n));

        StringBuffer sb = new StringBuffer();
        sb.append(Integer.toBinaryString(n));
        sb.reverse();
        System.out.println(sb.toString());

        // Integer.parseInt(sb.toString(), 2);
        System.out.println(Integer.parseUnsignedInt(sb.toString(), 2));
        System.out.println(Integer.parseInt(sb.toString(), 2));

        // return Integer.reverseBytes(n);

        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
