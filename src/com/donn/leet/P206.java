package com.donn.leet;

public class P206 {
    public ListNode reverseList(ListNode head) {
        return re(null, head);
    }

    public ListNode re(ListNode head, ListNode remain) {
        if (remain == null) {
            return head;
        } else {
            ListNode n = new ListNode(remain.val);
            // n.val = remain.val;
            n.next = remain.next;
            return re(n, remain.next);
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
