package com.donn.leet;

public class P143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        new P143().reorderList(head);
        Utils.printList(head);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new P143().reorderList(head);
        Utils.printList(head);

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode rhead = null;
        ListNode t = head;
        int len = 0;
        while (t != null) {
            ListNode n = new ListNode(t.val);
            n.next = rhead;
            rhead = n;
            t = t.next;
            len++;
        }

        t = head;
        ListNode rt = rhead;
        ListNode ct = null;
        int c = 1;
        while (c < len) {
            ct = rt.next;
            rt.next = t.next;
            t.next = rt;
            t = rt.next;
            rt = ct;
            c += 2;
        }
        t.next = null;
        if (c > len) {
            t = head;
            while (t != null) {
                if (t.next.next == null) {
                    t.next = null;
                    break;
                }
                t = t.next;
            }
        }

        return;
    }
}
