package org.example.dynamic_programming.decode_ways;

public class DecodingWaysRecursiveApproach {
    public int numDecodings(String s) {
        return countDecodings(0, s);
    }

    private int countDecodings(int idx, String s){
        if(idx >= s.length()){
            return 1;
        }

        if(s.charAt(idx) == '0'){
            return 0;
        }

        int waysToDecode = countDecodings(idx + 1, s);
        if(idx + 1 < s.length()){
            int twoDigitNum = s.charAt(idx) - '0';
            twoDigitNum = twoDigitNum * 10 + s.charAt(idx + 1) - '0';
            if(twoDigitNum <= 26){
                waysToDecode += countDecodings(idx + 2, s);
            }
        }

        return waysToDecode;
    }
}
