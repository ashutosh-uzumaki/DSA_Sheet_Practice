package org.example.recursion.subsequence_patterns;

import java.util.*;

public class GenerateBalancedParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(new StringBuilder(), 0, 0, ans, n);
        return ans;
    }

    private void helper(StringBuilder path, int open, int close, List<String> ans, int n){
        if(path.length() == 2 * n){
            ans.add(path.toString());
            return;
        }

        if(open < n){
            path.append('(');
            helper(path, open + 1, close, ans, n);
            path.deleteCharAt(path.length() - 1);
        }

        if(close < open){
            path.append(')');
            helper(path, open, close + 1, ans, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
