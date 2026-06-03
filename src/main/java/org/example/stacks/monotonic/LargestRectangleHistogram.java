package org.example.stacks.monotonic;

import java.util.*;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMostSmallest = new int[n];
        Arrays.fill(leftMostSmallest, -1);
        int[] rightMostSmallest = new int[n];
        Arrays.fill(rightMostSmallest, n);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                leftMostSmallest[i] = st.peek();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rightMostSmallest[i] = st.peek();
            }
            st.push(i);
        }

        int maxHeight = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            leftMostSmallest[i] += 1;
            rightMostSmallest[i] -= 1;
            maxHeight = Math.max(maxHeight, heights[i] * (rightMostSmallest[i] - leftMostSmallest[i] + 1));
        }

        return maxHeight;
    }
}
