package org.example.recursion.subsequence_patterns;

import java.util.*;

public class SubstringWithNoAdjancentZeros {
    public List<String> validStrings(int n) {
        if(n == 1){
            return List.of("0", "1");
        }
        List<String> binStrs = new ArrayList<>();
        char lastPlaced = 'A';
        helper(0, new StringBuilder(), lastPlaced, binStrs, n);
        return binStrs;
    }

    private void helper(int idx, StringBuilder sb, char lastPlaced, List<String> binStrs, int n){
        if(idx == n){
            binStrs.add(sb.toString());
            return;
        }

        sb.append('1');
        helper(idx + 1, sb, '1', binStrs, n);
        sb.deleteCharAt(sb.length() - 1);
        if(lastPlaced != '0'){
            sb.append('0');
            helper(idx + 1, sb, '0', binStrs, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
