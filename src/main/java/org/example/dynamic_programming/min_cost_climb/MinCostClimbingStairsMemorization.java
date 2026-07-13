package org.example.dynamic_programming.min_cost_climb;

import java.util.*;

public class MinCostClimbingStairsMemorization {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        int from0 = minCostToClimb(0, cost);
        int from1 = minCostToClimb(1, cost);

        return Math.min(from0, from1);
    }

    private int minCostToClimb(int i, int[] cost){
        if(i >= cost.length){
            return 0;
        }

        if(memo.containsKey(i)){
            return memo.get(i);
        }

        int oneStepCost = cost[i] + minCostToClimb(i + 1, cost);
        int twoStepCost = cost[i] + minCostToClimb(i + 2, cost);
        memo.put(i, Math.min(oneStepCost, twoStepCost));
        return Math.min(oneStepCost, twoStepCost);
    }
}
