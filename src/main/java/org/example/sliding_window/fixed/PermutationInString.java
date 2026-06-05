package org.example.sliding_window.fixed;

import java.util.*;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int[] srcCnt = new int[26];
        int[] targetCnt = new int[26];
        for(int i=0; i<s1.length(); i++){
            targetCnt[s1.charAt(i) - 'a'] += 1;
        }

        for(int i=0; i<s2.length(); i++){
            srcCnt[s2.charAt(i) - 'a'] += 1;

            if(i >= s1.length()){
                srcCnt[s2.charAt(i - s1.length()) - 'a'] -= 1;
            }

            if(i >= s1.length() - 1){
                if(Arrays.equals(srcCnt, targetCnt)){
                    return true;
                }
            }
        }

        return false;
    }
}
