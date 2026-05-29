package org.example.linkedlist;

public class InsertAtMid {
    public Node insertInMiddle(Node head, int x) {
        if(head == null) {
            head = new Node(x);
            return head;
        }
        Node mid = getMiddle(head);
        Node newNode = new Node(x);
        newNode.next = mid.next;
        mid.next = newNode;
        return head;
    }

    private Node getMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
