package com.donn.leet;

public class P67 {

    public String addBinary(String a, String b) {

        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        StringBuilder sb1 = new StringBuilder(a).reverse();
        StringBuilder sb2 = new StringBuilder(b).reverse();
        StringBuilder sb = new StringBuilder();

        char c = '0';
        for (int i = 0; i < sb1.length(); i++) {
            if (i >= sb2.length()) {
                if (sb1.charAt(i) == c) {
                    sb.append("0");
                } else {
                    sb.append("1");
                    c = '0';
                }
            } else {
                if (sb2.charAt(i) == c && sb1.charAt(i) == c) {
                    if (c == '1') {
                        sb.append("1");
                        c = '1';
                    } else {
                        sb.append("0");
                        c = '0';
                    }
                } else if (sb1.charAt(i) == '1' && sb2.charAt(i) == '1'
                    || sb1.charAt(i) == '1' && c == '1'
                    || sb2.charAt(i) == '1' && c == '1') {
                    sb.append("0");
                    c = '1';
                } else if (c == '1' || sb1.charAt(i) == '1' || sb2.charAt(i) == '1') {
                    sb.append("1");
                    c = '0';
                }
            }
        }
        if (c == '1') {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new P67().addBinary("11", "1"));
        System.out.println(new P67().addBinary("1010", "1011"));
        System.out.println(new P67().addBinary("1111111111", "1"));
    }

}
