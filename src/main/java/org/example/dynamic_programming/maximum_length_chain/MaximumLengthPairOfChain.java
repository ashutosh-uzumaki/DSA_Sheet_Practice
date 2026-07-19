package org.example.dynamic_programming.maximum_length_chain;

import java.util.*;

public class MaximumLengthPairOfChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] lis = new int[n];
        for(int i=0; i<n; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(pairs[i][0] > pairs[j][1]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        int max = 1;
        for(int i=0; i<n; i++){
            max = Math.max(lis[i], max);
        }

        return max;
    }
}
