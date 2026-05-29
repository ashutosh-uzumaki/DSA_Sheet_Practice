package org.example.stacks.monotonic;

import java.util.*;

public class NextGreaterElementCircular {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums.length];
        Arrays.fill(nge, -1);
        for(int i=0; i < 2 * nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i % nums.length]){
                nge[st.peek()] = nums[i % nums.length];
                st.pop();
            }
            if(i < nums.length){
                st.push(i);
            }
        }

        return nge;
    }
}
