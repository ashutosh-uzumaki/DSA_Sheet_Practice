package org.example.kadanes;

public class SightSeeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int bestPrev = values[0];
        int maxScore = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            maxScore = Math.max(maxScore, bestPrev + values[i] - i);
            bestPrev = Math.max(bestPrev, values[i] + i);
        }

        return maxScore;
    }
}
