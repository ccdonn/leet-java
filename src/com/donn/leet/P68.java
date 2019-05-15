package com.donn.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P68 {
    public List<String> fullJustify(String[] words, int maxWidth) {

        if (words.length == 0) {
            return Collections.emptyList();
        }

        List<String> r = new ArrayList<>();
        if (words.length == 1) {
            r.add(words[0] + spaces(maxWidth - words[0].length()));
            return r;
        }

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (sb.length() == 0) {
                sb.append(w);
            } else if (sb.length() + 1 + w.length() <= maxWidth) {
                sb.append(" ").append(w);
            } else {
                r.add(fitWithSpace(sb, maxWidth));
                sb.setLength(0);
                sb.append(w);
            }
        }
        if (sb.length() > 0) {
            // last time left-justified
            r.add(sb.append(spaces(maxWidth - sb.length())).toString());
        }
        return r;
    }

    private String fitWithSpace(StringBuilder str, int len) {

        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                total++;
            }
        }

        if (total == 0) {
            return str.append(spaces(len - str.length())).toString();
        }

        int counter = 0;
        int[] insertAt = new int[total];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                insertAt[counter++] = i;
            }
        }

        int paddingSpace = len - str.length();
        int aver = paddingSpace / total;
        int remain = paddingSpace % total;
        for (int i = counter - 1; i >= 0; i--) {
            int at = insertAt[i];
            String s = spaces(aver + (i < remain ? 1 : 0));
            str.insert(at, s);
        }
        return str.toString();
    }

    private String spaces(int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P68().fullJustify(new String[] { "a" }, 2));

        // System.out.println(new P68().fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification."
        // }, 16));

        // System.out.println(new P68().fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" },
        // 16));

        // System.out.println(new P68().fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well",
        // "enough", "to", "explain",
        // "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20));
    }
}
