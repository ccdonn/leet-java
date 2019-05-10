package com.donn.leet;

public class P12 {

    public String intToRoman(int num) {
        int I = 1;
        int IV = 4;
        int V = 5;
        int IX = 9;
        int X = 10;
        int XL = 40;

        int L = 50;
        int XC = 90;
        int C = 100;
        int CD = 400;
        int D = 500;
        int CM = 900;
        int M = 1000;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= M) {
                num -= M;
                sb.append("M");
            } else if (num >= CM) {
                num -= CM;
                sb.append("CM");
            } else if (num >= D) {
                num -= D;
                sb.append("D");
            } else if (num >= CD) {
                num -= CD;
                sb.append("CD");
            } else if (num >= C) {
                num -= C;
                sb.append("C");
            } else if (num >= XC) {
                num -= XC;
                sb.append("XC");
            } else if (num >= L) {
                num -= L;
                sb.append("L");
            } else if (num >= XL) {
                num -= XL;
                sb.append("XL");
            } else if (num >= X) {
                num -= X;
                sb.append("X");
            } else if (num >= IX) {
                num -= IX;
                sb.append("IX");
            } else if (num >= V) {
                num -= V;
                sb.append("V");
            } else if (num >= IV) {
                num -= IV;
                sb.append("IV");
            } else if (num >= I) {
                num -= I;
                sb.append("I");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P12().intToRoman(3));
        System.out.println(new P12().intToRoman(4));
        System.out.println(new P12().intToRoman(9));
        System.out.println(new P12().intToRoman(58));
        System.out.println(new P12().intToRoman(1994));
    }
}
