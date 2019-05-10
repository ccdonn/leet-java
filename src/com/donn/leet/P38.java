package com.donn.leet;

public class P38 {
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            System.out.println(new P38().countAndSay(i));
        }
    }

    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");

        for (int k = 1; k < n; k++) {
            StringBuilder ts = new StringBuilder("");

            Character val = null;
            int count = 1;

            for (int i = 0; i < s.length(); i++) {
                if (val == null) {
                    val = s.charAt(i);
                } else if (val.equals(s.charAt(i))) {
                    count++;
                } else {
                    ts.append(count).append(val);
                    val = s.charAt(i);
                    count = 1;
                }
            }
            ts.append(count).append(val);
            s = ts;
        }

        return s.toString();
    }
}
