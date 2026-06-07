package org.example.sliding_window.dynamic;

public class LongestReplacingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxLength = 0;
        int maxFreq = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            freq[s.charAt(right) - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int windowSize = right - left + 1;
            if(windowSize - maxFreq > k){
                freq[s.charAt(left) - 'A'] -= 1;
                left += 1;
                windowSize = right - left + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right += 1;
        }

        return maxLength;
    }
}
