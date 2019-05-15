package com.donn.leet;

public class P65 {
    public boolean isNumber(String s) {

        if (s == null) {
            return false;
        }

        s = s.trim();

        if (s.isEmpty()) {
            return false;
        }

        if (s.indexOf(" ") > -1) {
            return false;
        }
        // contains e
        if (s.indexOf("e") > -1) {
            // more than 1 e
            if (s.indexOf("e") != s.lastIndexOf("e")) {
                return false;
            } else {
                if (s.lastIndexOf(".") > s.indexOf("e")) {
                    return false;
                }
                return isNumber(s.substring(0, s.indexOf("e"))) && isNumber(s.substring(s.indexOf("e") + 1));
            }
        }

        // contains
        if (s.lastIndexOf("+") > 0 || s.lastIndexOf("-") > 0) {
            return false;
        } else {
            s = s.replace("+", "").replace("-", "");
        }

        if (s.indexOf(".") != s.lastIndexOf(".")) {
            return false;
        } else {
            s = s.replace(".", "");
        }

        if (s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P65().isNumber("0"));
        System.out.println(new P65().isNumber(" 0.1"));
        System.out.println(new P65().isNumber("abc"));
        System.out.println(new P65().isNumber("1 a"));
        System.out.println(new P65().isNumber("2e10"));
        System.out.println(new P65().isNumber(" -90e3 "));
        System.out.println(new P65().isNumber(" 1e"));
        System.out.println(new P65().isNumber("e3"));
        System.out.println(new P65().isNumber("6e-1"));
        System.out.println(new P65().isNumber("99e2.5"));

        System.out.println(new P65().isNumber("53.5e93"));
        System.out.println(new P65().isNumber(" --6"));
        System.out.println(new P65().isNumber("-+3"));
        System.out.println(new P65().isNumber("95a54e53"));

        System.out.println(new P65().isNumber("."));
    }
}
