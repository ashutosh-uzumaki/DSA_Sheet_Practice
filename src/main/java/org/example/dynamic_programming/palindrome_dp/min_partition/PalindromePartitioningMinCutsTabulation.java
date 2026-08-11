package org.example.dynamic_programming.palindrome_dp.min_partition;

public class PalindromePartitioningMinCutsTabulation {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = buildPalindromeTable(s);

        int[] dp = new int[n + 1];
        dp[n] = -1;

        for (int start = n - 1; start >= 0; start--) {
            int minCuts = Integer.MAX_VALUE;
            for (int end = start; end < n; end++) {
                if (isPalindrome[start][end]) {
                    int cuts = 1 + dp[end + 1];
                    minCuts = Math.min(minCuts, cuts);
                }
            }
            dp[start] = minCuts;
        }

        return dp[0];
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
