package org.example.linkedlist;

public class InsertAtHead {
    public Node insertAtHead(Node head, int X) {
        Node temp = new Node(X);
        temp.next = head;
        head = temp;
        return head;

    }
}
