package org.example.recursion.basic;

import java.util.*;

public class SortAStack {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }

        int top = st.pop();
        sortStack(st);
        insertSorted(st, top);
    }

    private void insertSorted(Stack<Integer> st, int val){
        if(st.isEmpty() || val >= st.peek()){
            st.push(val);
            return;
        }

        int top = st.pop();
        insertSorted(st, val);
        st.push(top);
    }
}
