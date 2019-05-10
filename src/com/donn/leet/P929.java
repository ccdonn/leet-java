package com.donn.leet;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P929 {

    public static void main(String[] args) {
        // System.out.println("testemail+david@lee.tcode.com".replaceAll( "\\.@", "").replaceAll("\\+\\w", ""));

        // System.out.println("testemail+david@lee.tcode.com".matches("[\\w\\.\\+]+"));
        Pattern p = Pattern.compile("([\\w\\.\\+]+)");
        Matcher m = p.matcher("teste.mail+david.t@lee.tcode.com");
        StringBuffer sb = new StringBuffer();
        // int count = 0;
        if (m.find()) {
            // count++;
            // System.out.println("found: " + count + " : "
            // + m.start() + " - " + m.end());
            // System.out.println(m.group(1));
            m.appendReplacement(sb, m.group(1).replace(".", "").replaceAll("\\+[\\w\\.]+", ""));

        }
        m.appendTail(sb);
        System.out.println(sb.toString());
        // System.out.println(m.matches());
        // System.out.println(m.groupCount());
        // System.out.println(m.group());
        // System.out.println(m.group(0));
        // System.out.println(m.group(1));

        // String text =
        // "John writes about this, and John writes about that," +
        // " and John writes about everything. ";
        //
        // String patternString1 = "(John)";
        //
        // Pattern pattern = Pattern.compile(patternString1);
        // Matcher matcher = pattern.matcher(text);
        //
        // while (matcher.find()) {
        // System.out.println("found: " + matcher.group(1));
        // }

        System.out.println(numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));
    }

    static Pattern p = Pattern.compile("([\\w\\.\\+]+)");

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        Matcher m;
        StringBuffer sb = new StringBuffer();
        for (String e : emails) {
            m = p.matcher(e);
            if (m.find()) {
                m.appendReplacement(sb, m.group(1).replace(".", "").replaceAll("\\+[\\w\\.]+", ""));
            } else {
                continue;
            }
            m.appendTail(sb);
            set.add(sb.toString());
            sb.setLength(0);
        }
        return set.size();
    }
}
