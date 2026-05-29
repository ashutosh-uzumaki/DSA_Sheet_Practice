package org.example.stacks;

import java.util.*;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        for(int i=0; i<pushed.length; i++){
            st.push(pushed[i]);

            while(!st.isEmpty() && idx < popped.length && st.peek() == popped[idx]){
                st.pop();
                idx += 1;
            }
        }

        return st.isEmpty();
    }
}
