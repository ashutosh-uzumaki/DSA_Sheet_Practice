package org.example.dynamic_programming.partition_dp.word_break;

import java.util.*;

public class WordBreakMemorization {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        memo = new Boolean[s.length()];
        for(String word: wordDict){
            set.add(word);
        }
        return helper(0, s, set);
    }

    private boolean helper(int idx, String s, HashSet<String> words){
        if(idx == s.length()){
            return true;
        }
        if(memo[idx] != null){
            return memo[idx];
        }
        for(int i = idx; i<s.length(); i++){
            String sub = s.substring(idx, i+1);
            if(words.contains(sub) && helper(i+1, s, words)){
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
}
