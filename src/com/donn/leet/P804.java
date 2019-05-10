package com.donn.leet;

import java.util.HashSet;
import java.util.Set;

public class P804 {

    static String[] array = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
        "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
    }

    public static int uniqueMorseRepresentations(String[] words) {

        Set<String> set = new HashSet<>();

        for (String s : words) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                sb.append(array[s.charAt(i) - 97]);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
