package org.example.dynamic_programming.knapsack_01;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        return helper(0, strs, m, n);
    }

    private int helper(int idx, String[] strs, int m, int n){
        if(idx == strs.length){
            return 0;
        }

        int zeroCnt = 0;
        int oneCnt = 0;
        for(char c: strs[idx].toCharArray()){
            if(c == '0'){
                zeroCnt += 1;
            }else{
                oneCnt += 1;
            }
        }

        int notSelected = helper(idx + 1, strs, m, n);
        int selected = 0;
        if(zeroCnt <= m && oneCnt <= n){
            selected = helper(idx + 1, strs, m - zeroCnt, n - oneCnt) + 1;
        }

        return Math.max(notSelected, selected);
    }
}
