package org.example.linkedlist;



public class InsertAtEnd {
    public Node insertAtEnd(Node head, int x) {
        // code here
        if(head == null){
            head = new Node(x);
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(x);
        return head;
    }
}
