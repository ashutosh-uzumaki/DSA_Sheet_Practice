package org.example.dynamic_programming.fibanocci.questions_with_brain_power;

public class SolvingMostQuestionsWithBrainPowerTabulation {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] best = new long[n + 1];
        best[n] = 0;
        for(int i = n-1; i>=0; i--){
            int chooseIdx = i + questions[i][1] + 1;
            long skip = best[i + 1];
            long choose = questions[i][0];
            if(chooseIdx <= n){
                choose += best[chooseIdx];
            }
            best[i] = Math.max(skip, choose);
        }
        return best[0];
    }
}
