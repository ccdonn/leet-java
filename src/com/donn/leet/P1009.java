package com.donn.leet;

public class P1009 {
    public static void main(String[] args) {
        System.out.println(new P1009().bitwiseComplement(0));
        System.out.println(new P1009().bitwiseComplement(1));
        System.out.println(new P1009().bitwiseComplement(2));
        System.out.println(new P1009().bitwiseComplement(5));
        System.out.println(new P1009().bitwiseComplement(7));
        System.out.println(new P1009().bitwiseComplement(10));
        // System.out.println(Math.log(5) / Math.log(2));
    }

    public int bitwiseComplement(int N) {
        return (N ^ (1 << Math.round(Math.floor(Math.log(N) / Math.log(2)) + 1)) - 1);
    }
}
