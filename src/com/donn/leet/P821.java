package com.donn.leet;

import java.util.Arrays;

public class P821 {
    public static void main(String[] args) {
        String s = new String("loveleetcode");
        char c = 'e';

        int[] a = run(s, c);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    static int[] run(String s, char c) {
        int[] array = new int[s.length()];
        Arrays.fill(array, -1);
        int index = 0;
        for (char cc : s.toCharArray()) {
            if (cc == c) {
                array[index] = 0;
            }
            index++;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (array[j] != -1 && array[j] == i) {
                    if (j > 0 && array[j - 1] == -1) {
                        array[j - 1] = i + 1;
                    }
                    if (j < s.length() - 1 && array[j + 1] == -1) {
                        array[j + 1] = i + 1;
                    }
                }
            }
        }

        return array;
    }
}
