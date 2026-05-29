package org.example.linkedlist.doublyll;

public class ListNode {
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode(){

    }
    public ListNode(int data){
        this.data = data;
    }
    public ListNode(int data, ListNode prev, ListNode next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
