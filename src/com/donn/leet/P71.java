package com.donn.leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71 {
    public String simplifyPath(String path) {
        // string.replaceAll take too much time
        // path.replaceAll("/+", "/").replaceAll("/$", "").replaceAll("^/", "");

        String[] paths = path.split("/");
        Deque<String> q = new ArrayDeque<>();
        for (String p : paths) {
            switch (p) {
                case "..":
                    if (!q.isEmpty()) {
                        q.pop();
                    }
                    break;
                case ".":
                case "":
                    break;
                default:
                    q.push(p);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.removeLast()).append("/");
        }
        return "/" + (sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
    }

    public static void main(String[] args) {
        System.out.println(new P71().simplifyPath("/home/"));
        System.out.println(new P71().simplifyPath("/.././"));
        System.out.println(new P71().simplifyPath("/home//foo/"));
        System.out.println(new P71().simplifyPath("/a/./b/../../c/"));
        System.out.println(new P71().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new P71().simplifyPath("/a//b////c/d//././/.."));
    }

}
