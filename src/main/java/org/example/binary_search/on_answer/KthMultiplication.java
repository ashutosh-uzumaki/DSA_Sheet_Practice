package org.example.binary_search.on_answer;

public class KthMultiplication {
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long count = 0;

        // Generate every non-empty subset
        for (int mask = 1; mask < (1 << n); mask++) {

            long subsetLcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    subsetLcm = lcm(subsetLcm, coins[i]);
                    bits++;
                }
            }

            // Inclusion-Exclusion
            if (bits % 2 == 1) {
                count += x / subsetLcm;
            } else {
                count -= x / subsetLcm;
            }
        }

        return count;
    }

    public long findKthSmallest(int[] coins, int k) {

        long left = 1;
        long right = (long) k * getMinCoin(coins);

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (count(mid, coins) >= k) {
                // There are already at least k valid
                // amounts <= mid.
                //
                // Therefore answer could be mid
                // or something smaller.
                right = mid;

            } else {
                // Fewer than k valid amounts <= mid.
                // Therefore answer must be greater than mid.
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMinCoin(int[] coins) {

        int min = coins[0];

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }
}
