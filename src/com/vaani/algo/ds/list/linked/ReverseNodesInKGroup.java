package com.vaani.algo.ds.list.linked;

import com.vaani.algo.ds.core.ListNode;

/**
 * Given a linked list, reverseIterative the nodes of a linked list k at a time and return its modified list.
 * <p>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ReverseNodesInKGroup test = new ReverseNodesInKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.display();
        test.reverseKGroup(head, 2).display();
        test.reverseKGroupIter(head, 2).display();
    }
    
    public ListNode reverseKGroupIter(ListNode head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return null;
        ListNode newHead = head;
        for (int i = 0; i < k; i++) {
            if (newHead == null) return head;
            newHead = newHead.next;
        }

        ListNode newGroupHead = reverseKGroup(newHead, k);
        ListNode pre = newGroupHead;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = findLength(head);
        if (head == null || k == 0 || len < k){
        	return head;
        }
        ListNode next = head;
        for (int i = 0; i < k; i++){
        	next = next.next;
        }
        ListNode node = reverse(head, k);
        head.next = reverseKGroup(next, k);
        return node;
    }

    public ListNode reverse(ListNode head, int len) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && len > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            len--;
        }
        return prev;
    }

    public int findLength(ListNode head) {
        if (head == null) return 0;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
