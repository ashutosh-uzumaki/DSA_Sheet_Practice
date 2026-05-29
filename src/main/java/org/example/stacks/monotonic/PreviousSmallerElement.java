package org.example.stacks.monotonic;

import java.util.*;

public class PreviousSmallerElement {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        ArrayList<Integer> pse = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            pse.add(-1);
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) pse.set(i, arr[st.peek()]);
            st.push(i);
        }
        return pse;
    }
}
