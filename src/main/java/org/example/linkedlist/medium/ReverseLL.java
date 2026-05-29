package org.example.linkedlist.medium;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        ListNode temp = head;
        while(temp != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
        return head;
    }
}
