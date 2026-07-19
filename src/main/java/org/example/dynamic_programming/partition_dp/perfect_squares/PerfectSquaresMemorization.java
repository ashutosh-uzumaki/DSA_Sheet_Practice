package org.example.dynamic_programming.partition_dp.perfect_squares;

public class PerfectSquaresMemorization {
    int[] memo;
    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return numSquaresHelper(n);
    }

    private int numSquaresHelper(int n){
        if(n == 0){
            return 0;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i <= n; i++){
            int currReq = 1 + numSquaresHelper(n - (i * i));
            min = Math.min(currReq, min);
        }
        return memo[n] = min;
    }
}
