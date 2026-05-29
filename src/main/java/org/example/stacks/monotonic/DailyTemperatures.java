package org.example.stacks.monotonic;

import java.util.*;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] waitDays = new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                waitDays[st.peek()] = i - st.pop();
            }
            st.push(i);
        }

        return waitDays;
    }
}
