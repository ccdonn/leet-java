package com.donn.leet;

public class P21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = null;
        ListNode t = null;
        while (l1 != null && l2 != null) {
            if (h == null) {
                if (l1.val > l2.val) {
                    h = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    h = new ListNode(l1.val);
                    l1 = l1.next;
                }
                t = h;
            } else {
                if (l1.val > l2.val) {
                    t.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    t.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                t = t.next;
            }
        }
        if (l1 != null) {
            if (t != null) {
                t.next = l1;
            } else {
                h = l1;
            }
        }
        if (l2 != null) {
            if (t != null) {
                t.next = l2;
            } else {
                h = l2;
            }
        }

        return h;
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        ListNode l2_4 = new ListNode(5);

        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;

        ListNode h = new P21().mergeTwoLists(l1_1, l2_1);
        System.out.println(h);
    }
}
