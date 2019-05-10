package com.donn.leet;

import java.math.BigInteger;

public class P2 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);

        ListNode head2 = new ListNode(1);
        ListNode t = head2;
        for (int i = 0; i < 9; i++) {
            t.next = new ListNode(9);
            t = t.next;
        }

        System.out.println(new P2().addTwoNumbers(head1, head2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toList(toNumber(l1), toNumber(l2));
    }

    private String toNumber(ListNode list) {
        StringBuilder sb = new StringBuilder();
        while (list.next != null) {
            sb.insert(0, list.val);
            list = list.next;
        }
        sb.insert(0, list.val);
        return sb.toString();
    }

    private ListNode toList(String a, String b) {
        ListNode list = null;
        BigInteger sum = new BigInteger(a).add(new BigInteger(b));
        String sumString = sum.toString();
        String[] sumStringArray = sumString.split("");
        list = new ListNode(Integer.parseInt(sumStringArray[sumStringArray.length - 1]));
        ListNode t = list;
        for (int i = sumStringArray.length - 2; i >= 0; i--) {
            t.next = new ListNode(Integer.parseInt(sumStringArray[i]));
            t = t.next;
        }
        return list;
    }
}

// class ListNode {
// int val;
// ListNode next;
//
// ListNode(int x) {
// val = x;
// }
// }
