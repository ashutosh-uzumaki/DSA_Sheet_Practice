package org.example.bit_manipulation.interview_problems;

public class MinBitsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int diff = start ^ goal;
        int cnt = 0;
        while(diff > 0){
            cnt += 1;
            diff = diff & (diff - 1);
        }
        return cnt;
    }
}
