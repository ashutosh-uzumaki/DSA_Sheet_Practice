package org.example.stacks.monotonic;

import java.util.*;

public class SubarraySumOfMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        final int mod = (int)(1e9 + 7);
        Arrays.fill(pse, -1);
        Arrays.fill(nse, n);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                pse[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                nse[i] = st.peek();
            }

            st.push(i);
        }

        int totalSum = 0;

        for(int i=0; i<n; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long contri = ((long)arr[i] % mod * ((long)left % mod * right % mod) % mod) % mod;
            totalSum = (int)((totalSum + contri) % mod);
        }

        return totalSum % mod;
    }
}
