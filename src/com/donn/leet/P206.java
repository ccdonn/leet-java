package com.donn.leet;

public class P206 {
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

		Utils.printList(l1);
		Utils.printList(new P206().reverseList(l1));
	}
    public ListNode reverseList(ListNode head) {
        return re(null, head);
    }

    public ListNode re(ListNode head, ListNode remain) {
        if (remain == null) {
            return head;
        } else {
            ListNode n = new ListNode(remain.val);
            // n.val = remain.val;
            n.next = head;
            return re(n, remain.next);
        }
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
}
