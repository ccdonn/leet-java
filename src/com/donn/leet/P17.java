package com.donn.leet;

import java.util.ArrayList;
import java.util.List;

public class P17 {
    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            l = v(digits.charAt(i), l);
        }

        return l;
    }

    private List<String> v(Character c, List<String> list) {
        List<String> n = new ArrayList<>();
        switch (c) {
            case '2':
                if (list.isEmpty()) {
                    n.add("a");
                    n.add("b");
                    n.add("c");
                } else {
                    list.forEach(v -> {
                        n.add(v + "a");
                        n.add(v + "b");
                        n.add(v + "c");
                    });
                }
                break;
            case '3':
                if (list.isEmpty()) {
                    n.add("d");
                    n.add("e");
                    n.add("f");
                } else {
                    list.forEach(v -> {
                        n.add(v + "d");
                        n.add(v + "e");
                        n.add(v + "f");
                    });
                }
                break;
            case '4':
                if (list.isEmpty()) {
                    n.add("g");
                    n.add("h");
                    n.add("i");
                } else {
                    list.forEach(v -> {
                        n.add(v + "g");
                        n.add(v + "h");
                        n.add(v + "i");
                    });
                }
                break;
            case '5':
                if (list.isEmpty()) {
                    n.add("j");
                    n.add("k");
                    n.add("l");
                } else {
                    list.forEach(v -> {
                        n.add(v + "j");
                        n.add(v + "k");
                        n.add(v + "l");
                    });
                }
                break;
            case '6':
                if (list.isEmpty()) {
                    n.add("m");
                    n.add("n");
                    n.add("o");
                } else {
                    list.forEach(v -> {
                        n.add(v + "m");
                        n.add(v + "n");
                        n.add(v + "o");
                    });
                }
                break;
            case '7':
                if (list.isEmpty()) {
                    n.add("p");
                    n.add("q");
                    n.add("r");
                    n.add("s");
                } else {
                    list.forEach(v -> {
                        n.add(v + "p");
                        n.add(v + "q");
                        n.add(v + "r");
                        n.add(v + "s");
                    });
                }
                break;
            case '8':
                if (list.isEmpty()) {
                    n.add("t");
                    n.add("u");
                    n.add("v");
                } else {
                    list.forEach(v -> {
                        n.add(v + "t");
                        n.add(v + "u");
                        n.add(v + "v");
                    });
                }
                break;
            case '9':
                if (list.isEmpty()) {
                    n.add("w");
                    n.add("x");
                    n.add("y");
                    n.add("z");
                } else {
                    list.forEach(v -> {
                        n.add(v + "w");
                        n.add(v + "x");
                        n.add(v + "y");
                        n.add(v + "z");
                    });
                }
                break;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new P17().letterCombinations("23"));
    }
}
