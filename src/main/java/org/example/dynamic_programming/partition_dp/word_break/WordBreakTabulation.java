package org.example.dynamic_programming.partition_dp.word_break;

import java.util.*;

public class WordBreakTabulation {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>();
        for(String word: wordDict){
            words.add(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                String substr = s.substring(i, j+1);
                if(words.contains(substr) && dp[j + 1]){
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }
}
