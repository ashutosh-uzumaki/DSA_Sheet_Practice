package org.example.dynamic_programming.longest_string_chain;

import java.util.*;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int maxLen = 1;
        int size = words.length;
        int[] chain = new int[size];

        for(int i=0; i<size; i++){
            chain[i] = 1;
            for(int j=0; j<i; j++){
                if(words[j].length() == words[i].length() - 1 && isPredecessor(words[j], words[i])){
                    chain[i] = Math.max(chain[i], chain[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, chain[i]);
        }
        return maxLen;
    }

    private boolean isPredecessor(String shorterWord, String largerWord){
        int m = shorterWord.length();
        int n = largerWord.length();
        int i = 0, j = 0;
        boolean skippedOnce = false;
        while(i < m && j < n){
            if(shorterWord.charAt(i) == largerWord.charAt(j)){
                i++;
                j++;
            }else{
                j++;
                if(skippedOnce){
                    return false;
                }
                skippedOnce = true;
            }
        }

        return true;
    }
}
