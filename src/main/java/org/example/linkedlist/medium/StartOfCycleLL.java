package org.example.linkedlist.medium;

public class StartOfCycleLL {
    public ListNode findStartingPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }

        slow = head;
        int idx = 0;
        while(slow != fast){
            idx += 1;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
