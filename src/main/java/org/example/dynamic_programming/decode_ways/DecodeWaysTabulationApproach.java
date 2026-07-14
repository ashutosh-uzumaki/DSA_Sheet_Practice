package org.example.dynamic_programming.decode_ways;

public class DecodeWaysTabulationApproach {
    public int numDecodings(String s) {
        int n = s.length();
        int[] waysToDecode = new int[n + 1];
        waysToDecode[n] = 1;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                waysToDecode[i] = 0;
                continue;
            }

            waysToDecode[i] = waysToDecode[i + 1];
            if(i + 1 < s.length()){
                int num = s.charAt(i) - '0';
                num = num * 10 + (s.charAt(i + 1) - '0');
                if(num <= 26){
                    waysToDecode[i] += waysToDecode[i + 2];
                }
            }

        }

        return waysToDecode[0];
    }
}
