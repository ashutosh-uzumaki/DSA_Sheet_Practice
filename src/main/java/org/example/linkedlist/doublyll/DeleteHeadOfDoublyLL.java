package org.example.linkedlist.doublyll;

public class DeleteHeadOfDoublyLL {
    public ListNode deleteHead(ListNode head) {
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return head;
    }
}
