package org.example.linkedlist;

public class LengthOfLL {
    public int getCount(Node head) {
        if(head == null){
            return 0;
        }

        return 1 + getCount(head.next);
    }
}
