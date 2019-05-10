package com.donn.leet;

public class P2_2 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);

        ListNode head2 = new ListNode(1);
        ListNode t = head2;
        for (int i = 0; i < 2; i++) {
            t.next = new ListNode(9);
            t = t.next;
        }

        System.out.println(new P2_2().addTwoNumbers(head1, head2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nList = null;

        int c = 0;

        if (l1.val + l2.val >= 10) {
            nList = new ListNode((l1.val + l2.val) % 10);
            c = 1;
        } else {
            nList = new ListNode(l1.val + l2.val);
        }

        ListNode t = nList;
        while (l1.next != null || l2.next != null || c > 0) {
            if (l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
                if (l1.val + l2.val + c >= 10) {
                    t.next = new ListNode((l1.val + l2.val + c) % 10);
                    c = 1;
                } else {
                    t.next = new ListNode(l1.val + l2.val + c);
                    c = 0;
                }
            } else if (l1.next != null) {
                l1 = l1.next;
                if (c > 0) {
                    if (l1.val + c >= 10) {
                        t.next = new ListNode((l1.val + c) % 10);
                        c = 1;
                    } else {
                        t.next = new ListNode(l1.val + c);
                        c = 0;
                    }
                } else {
                    t.next = new ListNode(l1.val);
                }
            } else if (l2.next != null) {
                l2 = l2.next;
                if (c > 0) {
                    if (l2.val + c >= 10) {
                        t.next = new ListNode((l2.val + c) % 10);
                        c = 1;
                    } else {
                        t.next = new ListNode(l2.val + c);
                        c = 0;
                    }
                } else {
                    t.next = new ListNode(l2.val);
                }
            } else if (c > 0) {
                t.next = new ListNode(1);
                c = 0;
            }
            t = t.next;
        }
        return nList;
    }

}
