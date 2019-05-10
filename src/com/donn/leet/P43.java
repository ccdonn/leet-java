package com.donn.leet;

public class P43 {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        StringBuilder sum = new StringBuilder("0");

        int k = 0;
        for (char c2 : sb2.toString().toCharArray()) {
            String tsum = "";
            for (int i = 0; i < c2 - '0'; i++) {
                tsum = plus(tsum, sb1.toString());
            }
            // padding
            for (int i = sb2.length() - 1; i > k; i--) {
                tsum += "0";
            }
            sum = new StringBuilder(plus(sum.toString(), tsum));
            k++;
        }
        if (sum.length() == 0) {
            return "0";
        }
        return sum.toString();
    }

    public String plus(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        StringBuilder sum = new StringBuilder();
        int c = 0;
        while (sb1.length() > 0 || sb2.length() > 0 || c != 0) {
            String r = null;
            if (c == 0) {
                r = plus(sb1.length() > 0 ? sb1.charAt(0) : '0', sb2.length() > 0 ? sb2.charAt(0) : '0');
            } else {
                r = plus(sb1.length() > 0 ? sb1.charAt(0) : '0', sb2.length() > 0 ? sb2.charAt(0) : '0', '1');
            }
            if (r.length() > 1) {
                c = 1;
                sum.append(r.charAt(1));
            } else {
                c = 0;
                sum.append(r);
            }
            if (sb1.length() > 0) {
                sb1.deleteCharAt(0);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(0);
            }
        }
        return sum.reverse().toString();
    }

    private String plus(char n1, char n2, char n3) {
        int c = n1 + n2 + n3 - '0' - '0';
        if (c > '9') {
            return "1" + String.valueOf((char) ((int) c - 10));
        } else {
            return String.valueOf((char) c);
        }
    }

    private String plus(char n1, char n2) {
        return plus(n1, n2, '0');
    }

    // private static String multiply(char n1, char n2) {
    // int c = n1 * n2 - (n1 - '0') * '0' - (n2 - '0') * '0' - '0' * '0' + '0';
    // return String.valueOf((char) c);
    // }

    public static void main(String[] args) {
        // System.out.println(new P43().plus('0', '0'));
        // System.out.println(new P43().plus('2', '0'));
        // System.out.println(new P43().plus('9', '0'));
        // System.out.println(new P43().plus('9', '9'));
        // System.out.println(new P43().plus('9', '9', '1'));
        //
        // System.out.println(new P43().plus("0", "0"));
        // System.out.println(new P43().plus("2", "0"));
        // System.out.println(new P43().plus("9", "0"));
        // System.out.println(new P43().plus("9", "9"));
        // System.out.println(new P43().plus("123", "3"));
        // System.out.println(new P43().plus("3", "123"));
        // System.out.println(new P43().plus("123", "123"));
        // System.out.println(new P43().plus("123123123123123123123123", "123123123123123123123123"));
        //
        // System.out.println(new P43().multiply('2', '0'));
        // System.out.println(new P43().multiply('2', '1'));
        // System.out.println(new P43().multiply('2', '3'));

        System.out.println(new P43().multiply("2", "0"));
        System.out.println(new P43().multiply("2", "1"));
        System.out.println(new P43().multiply("2", "3"));
        System.out.println(new P43().multiply("4", "3"));
        System.out.println(new P43().multiply("4", "6"));
        System.out.println(new P43().multiply("9", "9"));
        System.out.println(new P43().multiply("123", "456"));
        System.out.println(new P43().multiply("999", "999"));
    }
}
