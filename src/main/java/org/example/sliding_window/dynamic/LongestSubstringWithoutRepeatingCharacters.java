package org.example.sliding_window.dynamic;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int[] freq = new int[128];
        while(right < s.length()){
            freq[s.charAt(right)] += 1;
            while(left <= right && freq[s.charAt(right)] > 1){
                freq[s.charAt(left)] -= 1;
                left += 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right += 1;
        }

        return maxLen;
    }
}
