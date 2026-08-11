package org.example.dynamic_programming.palindrome_dp.min_partition;

import java.util.Arrays;

public class PalindromePartitioningMinCutsMemorization {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = buildPalindromeTable(s);

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(0, s, isPalindrome, memo);
    }

    private int helper(int start, String s, boolean[][] isPalindrome, int[] memo) {
        if (start == s.length()) {
            return -1; // no cut needed after the last character
        }
        if (memo[start] != -1) {
            return memo[start];
        }

        int minCuts = Integer.MAX_VALUE;
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                int cuts = 1 + helper(end + 1, s, isPalindrome, memo);
                minCuts = Math.min(minCuts, cuts);
            }
        }

        return memo[start] = minCuts;
    }

    private boolean[][] buildPalindromeTable(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int start = n - 1; start >= 0; start--) {
            for (int end = start; end < n; end++) {
                if (start == end) {
                    isPalindrome[start][end] = true;
                } else if (s.charAt(start) == s.charAt(end)) {
                    isPalindrome[start][end] = (end == start + 1) || isPalindrome[start + 1][end - 1];
                }
            }
        }

        return isPalindrome;
    }
}
