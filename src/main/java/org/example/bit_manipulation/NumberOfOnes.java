package org.example.bit_manipulation;

public class NumberOfOnes {
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n > 0){
            cnt += 1;
            n = n & (n-1);
        }
        return cnt;
    }
}
