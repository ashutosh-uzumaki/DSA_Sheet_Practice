package org.example.dynamic_programming.largest_divisible_subset;

import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;

        int[] lis = new int[size];
        int[] parent = new int[size];

        for (int i = 0; i < size; i++) {
            lis[i] = 1;       // base case: each element alone is a valid chain of length 1
            parent[i] = -1;   // no predecessor yet

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {          // divisibility check, not just "smaller"
                    if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }

        // find the index holding the largest chain
        int maxIdx = 0;
        for (int i = 1; i < size; i++) {
            if (lis[i] > lis[maxIdx]) maxIdx = i;
        }

        // walk parent[] backward to rebuild the actual chain
        List<Integer> result = new ArrayList<>();
        int cur = maxIdx;
        while (cur != -1) {
            result.add(nums[cur]);
            cur = parent[cur];
        }

        Collections.reverse(result);  // built backward, so reverse to get ascending order
        return result;
    }
}
