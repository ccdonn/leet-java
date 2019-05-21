package com.donn.leet;

public class P92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        int cntr = 1;
        ListNode t = head;
        ListNode nNode = null;
        ListNode nt = null;
        ListNode r = null;
        ListNode rt = null;

        while (t != null) {
            if (cntr == m) {
                r = new ListNode(t.val);
                rt = r;
            } else if (cntr == n) {
                ListNode rn = new ListNode(t.val);
                rn.next = r;
                r = rn;
                if (nt == null) {
                    nNode = r;
                    // nt = r;
                    nt = rt;
                } else {
                    nt.next = r;
                    nt = rt;
                }
            } else if (cntr > m && cntr < n) {
                ListNode rn = new ListNode(t.val);
                rn.next = r;
                r = rn;
            } else if (cntr < m) {
                if (nt == null) {
                    nNode = t;
                } else {
                    nt.next = t;
                }
                nt = t;
            } else if (cntr > n) {
                nt.next = t;
                nt = t;
            }
            t = t.next;
            cntr++;
        }
        return nNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Utils.printList(n1);
        // Utils.printList(new P92().reverseBetween(n1, 1, 4));
        // Utils.printList(new P92().reverseBetween(n1, 2, 4));
        // Utils.printList(new P92().reverseBetween(n1, 2, 3));
        Utils.printList(new P92().reverseBetween(n1, 2, 5));
    }
}
