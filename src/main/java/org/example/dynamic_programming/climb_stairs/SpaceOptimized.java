package org.example.dynamic_programming.climb_stairs;

public class SpaceOptimized {
        public int climbStairs(int n) {
            int prev = 1;
            int secondPrev = 1;

            for(int i=2; i<=n; i++){
                int curr = prev + secondPrev;
                prev = secondPrev;
                secondPrev = curr;
            }
            return secondPrev;
        }
}
