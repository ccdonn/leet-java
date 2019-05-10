package com.donn.leet;

public class P13 {

    public int romanToInt(String s) {

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

        int val = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == 'M') {
                val += M;
                i++;
            } else if (s.charAt(i) == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                val += CM;
                i += 2;
            } else if (s.charAt(i) == 'D') {
                val += D;
                i++;
            } else if (s.charAt(i) == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                val += CD;
                i += 2;
            } else if (s.charAt(i) == 'C') {
                val += C;
                i++;
            } else if (s.charAt(i) == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                val += XC;
                i += 2;
            } else if (s.charAt(i) == 'L') {
                val += L;
                i++;
            } else if (s.charAt(i) == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                val += XL;
                i += 2;
            } else if (s.charAt(i) == 'X') {
                val += X;
                i++;
            } else if (s.charAt(i) == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                val += IX;
                i += 2;
            } else if (s.charAt(i) == 'V') {
                val += V;
                i++;
            } else if (s.charAt(i) == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                val += IV;
                i += 2;
            } else if (s.charAt(i) == 'I') {
                val += I;
                i++;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new P13().romanToInt("III"));
        System.out.println(new P13().romanToInt("IV"));
        System.out.println(new P13().romanToInt("IX"));
        System.out.println(new P13().romanToInt("LVIII"));
        System.out.println(new P13().romanToInt("MCMXCIV"));
    }
}
