package org.example.dynamic_programming.palindrome_dp.largest_palindrome;

public class LargestPalindromeSubstringBruteForce {
    public String longestPalindrome(String s) {
        int start = -1;
        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i<s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);

            int maxLenAsCentreI = Math.max(len1, len2);
            if(maxLenAsCentreI > maxLength){
                start = i - (maxLenAsCentreI - 1) / 2;
                maxLength = maxLenAsCentreI;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left -= 1;
            right += 1;
        }

        return right - left - 1;
    }
}
