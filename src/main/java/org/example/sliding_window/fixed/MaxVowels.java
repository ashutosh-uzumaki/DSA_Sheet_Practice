package org.example.sliding_window.fixed;

import java.util.*;

public class MaxVowels {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;

        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                count += 1;
            }

            if(i >= k){
                if(set.contains(s.charAt(i - k))){
                    count -= 1;
                }
            }

            if(i >= k-1){
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}
