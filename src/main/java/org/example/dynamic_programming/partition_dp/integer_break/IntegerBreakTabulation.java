package org.example.dynamic_programming.partition_dp.integer_break;

public class IntegerBreakTabulation {
    public int integerBreak(int n) {
        int[] best = new int[n + 1];
        best[1] = 1;

        for (int num = 2; num <= n; num++) {
            int running = Integer.MIN_VALUE;
            for (int i = 1; i < num; i++) {
                int noBreak = i * (num - i);
                int furtherBreak = i * best[num - i];
                running = Math.max(running, Math.max(noBreak, furtherBreak));
            }
            best[num] = running;
        }

        return best[n];
    }
}
