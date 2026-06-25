package org.example.greedy;

import java.util.*;

public class MaximumScoreAfterRemovingSubstring {
    public int maximumGain(String s, int x, int y) {
        String a = "ab";
        String b = "ba";
        if (x < y) {
            String temp = a; a = b; b = temp;
            int ti = x; x = y; y = ti;
        }

        int totalPoints = 0;
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == a.charAt(1) && !st.isEmpty() && st.peek() == a.charAt(0)) {
                st.pop();
                totalPoints += x;
            } else {
                st.push(c);
            }
        }

        // Remaining string
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        sb.reverse();

        // Second pass: remove lower value pair (b)
        for (char c : sb.toString().toCharArray()) {
            if (c == b.charAt(1) && !st.isEmpty() && st.peek() == b.charAt(0)) {
                st.pop();
                totalPoints += y;
            } else {
                st.push(c);
            }
        }

        return totalPoints;
    }
}
