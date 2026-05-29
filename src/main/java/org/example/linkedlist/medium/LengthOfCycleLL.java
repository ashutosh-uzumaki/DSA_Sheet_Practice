package org.example.linkedlist.medium;

public class LengthOfCycleLL {
    public int findLengthOfLoop(ListNode head) {
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
            return 0;
        }
        int count = 1;
        fast = fast.next;
        while(fast != slow){
            count += 1;
            fast = fast.next;
        }

        return count;
    }
}
