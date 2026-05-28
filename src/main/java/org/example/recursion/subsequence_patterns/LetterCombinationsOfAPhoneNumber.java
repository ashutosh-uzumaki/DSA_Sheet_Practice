package org.example.recursion.subsequence_patterns;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0){
            return new ArrayList<>();
        }
        HashMap<Integer, String> digitMap = new HashMap<>();
        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");
        List<String> combinations = new ArrayList<>();
        generateCombinations(digits, digitMap, 0, new StringBuilder(), combinations);
        return combinations;
    }

    public void generateCombinations(String digits, HashMap<Integer, String> digitMap, int idx, StringBuilder sb, List<String> combinations){
        if(idx == digits.length()){
            combinations.add(sb.toString());
            return;
        }

        String currString = digitMap.get(digits.charAt(idx)-'0');
        for(int subIdx = 0; subIdx < currString.length(); subIdx++){
            sb.append(currString.charAt(subIdx));
            generateCombinations(digits, digitMap, idx + 1, sb, combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
