package org.example.recursion.basic;

public class CountGoodNumbers {
    long mod = (long)(1e9 + 7);
    public int countGoodNumbers(long n) {
        long evenDigits = (n + 1) / 2;
        long oddDigits = n/2;

        int totalGoodNumbers = (int)((pow(5, evenDigits) * pow(4, oddDigits)) % mod);
        return totalGoodNumbers;
    }

    private long pow(long x, long n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        long halfAns = pow(x, n/2);
        if(n % 2 == 0){
            return (halfAns % mod * halfAns % mod) % mod;
        }
        return ((halfAns % mod * halfAns % mod) * x % mod) % mod;
    }
}
