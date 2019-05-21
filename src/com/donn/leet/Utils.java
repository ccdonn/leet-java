package com.donn.leet;

import java.util.Arrays;

public class Utils {

    public static void printArray(int[][] array) {
        StringBuilder sb = new StringBuilder();
        if (array.length == 0 || array[0].length == 0) {
            System.out.println(sb.toString());
        } else {
            sb.append("[");
            Arrays.stream(array).forEach(v -> {
                sb.append("[");
                Arrays.stream(v).forEach(vv -> {
                    sb.append(vv).append(", ");
                });
                sb.setLength(sb.length() - 2);
                sb.append("],");
            });
            sb.setLength(sb.length() - 1);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(head.val);
        while (head.next != null) {
            head = head.next;
            sb.append("->").append(head.val);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void buildTree(Integer[] is) {
    }

}