package com.donn.leet;

public class P61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null || k == 0) {
            return head;
        }

        ListNode t = head;
        int count = 1;
        while (t.next != null) {
            t = t.next;
            count++;
        }
        t.next = head;

        t = head;
        ListNode nhead;
        ListNode preHead = null;
        for (int i = 0; i < count - (k % count); i++) {
            if (i == count - (k % count) - 1) {
                preHead = t;
            }
            t = t.next;
        }
        nhead = t;
        preHead.next = null;
        return nhead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode t1 = new P61().rotateRight(head1, 2);

        head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        ListNode t2 = new P61().rotateRight(head1, 4);

    }
}
