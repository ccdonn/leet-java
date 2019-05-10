package com.donn.leet;

public class P434 {
    public static void main(String[] args) {
        String s = " , , sada";
        System.out.println(s.trim().replaceAll("[ ]+", " ").split(" ").length);
    }

}
