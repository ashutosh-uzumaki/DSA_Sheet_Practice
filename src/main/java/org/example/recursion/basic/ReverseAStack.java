package org.example.recursion.basic;

import java.util.*;

public class ReverseAStack {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }

    private static void insertAtBottom(Stack<Integer> st, int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, val);
        st.push(top);
    }
}
