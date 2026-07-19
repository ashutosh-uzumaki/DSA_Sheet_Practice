package org.example.dynamic_programming.partition_dp.partition_label;

import java.util.*;

public class PartitionLabel {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastOccur = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccur[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int currentEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            currentEnd = Math.max(currentEnd, lastOccur[s.charAt(i) - 'a']);
            if (i == currentEnd) {
                ans.add(currentEnd - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
