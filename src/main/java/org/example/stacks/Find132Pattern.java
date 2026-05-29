package org.example.stacks;

import java.util.*;

public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length - 1;
        Stack<Integer> st = new Stack<>();
        int third = Integer.MIN_VALUE;
        for(int i=n; i>=0; i--){
            if(nums[i] < third){
                return true;
            }

            while(!st.isEmpty() && st.peek() < nums[i]){
                third = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}
