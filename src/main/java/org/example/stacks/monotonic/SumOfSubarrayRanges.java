package org.example.stacks.monotonic;

import java.util.*;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> smallerStack = new Stack<>();
        Stack<Integer> largerStack = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        int[] pge = new int[n];
        int[] nse = new int[n];
        int[] pse = new int[n];
        Arrays.fill(nge, n);
        Arrays.fill(nse, n);
        Arrays.fill(pse, -1);
        Arrays.fill(pge, -1);
        for(int i=0; i<n; i++){
            while(!smallerStack.isEmpty() && nums[smallerStack.peek()] >= nums[i]){
                smallerStack.pop();
            }
            if(!smallerStack.isEmpty()){
                pse[i] = smallerStack.peek();
            }
            while(!largerStack.isEmpty() && nums[largerStack.peek()] <= nums[i]){
                largerStack.pop();
            }
            if(!largerStack.isEmpty()){
                pge[i] = largerStack.peek();
            }

            smallerStack.push(i);
            largerStack.push(i);
        }
        smallerStack = new Stack<>();
        largerStack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!smallerStack.isEmpty() && nums[smallerStack.peek()] > nums[i]){
                smallerStack.pop();
            }
            if(!smallerStack.isEmpty()){
                nse[i] = smallerStack.peek();
            }
            while(!largerStack.isEmpty() && nums[largerStack.peek()] < nums[i]){
                largerStack.pop();
            }
            if(!largerStack.isEmpty()){
                nge[i] = largerStack.peek();
            }

            smallerStack.push(i);
            largerStack.push(i);
        }

        long totalSum = 0;
        for(int i=0; i<n; i++){
            int left = i - pge[i];
            int right = nge[i] - i;

            long largerContri = (long)nums[i] * ((long)(left * right));
            left = i - pse[i];
            right = nse[i] - i;
            long smallerContri = -(long)nums[i] * ((long)left * right);

            totalSum += (largerContri + smallerContri);
        }

        return totalSum;
    }
}
