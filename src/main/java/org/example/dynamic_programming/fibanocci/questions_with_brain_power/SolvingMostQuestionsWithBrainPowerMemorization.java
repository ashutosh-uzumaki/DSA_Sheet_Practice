package org.example.dynamic_programming.fibanocci.questions_with_brain_power;

import java.util.*;

public class SolvingMostQuestionsWithBrainPowerMemorization {
    private final HashMap<Integer, Long> memo = new HashMap<>();
    public long mostPoints(int[][] questions) {
        int n = questions.length;

        return getMostPoints(0, questions, n);
    }

    private long getMostPoints(int idx, int[][] questions, int n){
        if(idx >= n){
            return 0;
        }

        if(memo.containsKey(idx)){
            return memo.get(idx);
        }

        long skip = getMostPoints(idx + 1, questions, n);
        long choose = questions[idx][0] + getMostPoints(idx + questions[idx][1] + 1, questions, n);

        memo.put(idx, Math.max(skip, choose));
        return Math.max(skip, choose);
    }
}
