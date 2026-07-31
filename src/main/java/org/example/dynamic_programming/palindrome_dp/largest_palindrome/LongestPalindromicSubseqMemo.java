package org.example.dynamic_programming.palindrome_dp.largest_palindrome;

import java.util.*;

public class LongestPalindromicSubseqMemo {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        memo = new int[s.length()][s.length()];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return findLongestPalindromeSubseq(0, s.length() - 1, s);
    }

    private int findLongestPalindromeSubseq(int left, int right, String s){
        if(left > right){
            return 0;
        }
        if(left == right){
            return 1;
        }

        if(memo[left][right] != -1){
            return memo[left][right];
        }

        if(s.charAt(left) == s.charAt(right)){
            return memo[left][right] = 2 + findLongestPalindromeSubseq(left + 1, right - 1, s);
        }else{
            return memo[left][right] = Math.max(
                    findLongestPalindromeSubseq(left + 1, right, s),
                    findLongestPalindromeSubseq(left, right - 1, s)
            );
        }
    }
}
