package org.example.linkedlist;

public class DeleteNodeAtHead {
    public Node deleteHead(Node head) {
        if(head == null || head.next == null){
            return null;
        }

        head = head.next;
        return head;
    }
}
