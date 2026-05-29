package org.example.stacks.monotonic;

import java.util.*;

public class PreviousGreaterElement {
    public ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        ArrayList<Integer> pge = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            pge.add(-1);
        }

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                pge.set(i, arr[st.peek()]);
            }
            st.push(i);
        }

        return pge;
    }
}
