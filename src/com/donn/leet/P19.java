package com.donn.leet;

public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode t = head;
        int len = 0;
        while (t != null) {
            len++;
            t = t.next;
        }

        if (n == len) {
            return head.next;
        }

        t = head;
        for (int i = 0; i < len; i++) {
            if (len - i == n + 1) {
                t.next = t.next.next;
                break;
            }
            t = t.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode h = new P19().removeNthFromEnd(l1, 1);
        System.out.println(h);
    }

}
