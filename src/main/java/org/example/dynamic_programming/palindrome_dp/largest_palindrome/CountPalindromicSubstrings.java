package org.example.dynamic_programming.palindrome_dp.largest_palindrome;

public class CountPalindromicSubstrings {
    public int countSubstrings(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        int count = 0;
        for(int i=size-1; i>=0; i--){
            for(int j=i; j<size; j++){
                if(i == j){
                    dp[i][j] = true;
                }else if(j - i == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]);
                }
                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
