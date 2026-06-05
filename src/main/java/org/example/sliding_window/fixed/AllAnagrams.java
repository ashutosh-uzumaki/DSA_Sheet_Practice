package org.example.sliding_window.fixed;

import java.util.*;

public class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(char c: p.toCharArray()){
            pCnt[c - 'a'] += 1;
        }

        for(int i=0; i<s.length(); i++){
            sCnt[s.charAt(i) - 'a'] += 1;
            if(i >= p.length()){
                sCnt[s.charAt(i - p.length()) - 'a'] -= 1;
            }

            if(i >= p.length() - 1){
                if(Arrays.equals(sCnt, pCnt)){
                    ans.add(i - p.length() + 1);
                }
            }
        }

        return ans;
    }
}
