package org.example.linkedlist.doublyll;

public class InsertAtHead {
    public ListNode insertBeforeHead(ListNode head, int data) {
        ListNode temp = new ListNode(data);
        temp.next = head;
        if(head != null){
            head.prev = temp;
        }
        head = temp;
        return head;
    }
}
