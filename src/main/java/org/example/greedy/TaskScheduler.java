package org.example.greedy;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = Integer.MIN_VALUE;
        for(char c: tasks){
            freq[c - 'A'] += 1;
            maxFreq = Math.max(freq[c-'A'], maxFreq);
        }
        int freqCnt = 0;
        for(int i=0; i<26; i++){
            if(freq[i] == maxFreq){
                freqCnt += 1;
            }
        }

        int totalInterval = (maxFreq - 1) * (n + 1) + freqCnt;
        return Math.max(totalInterval, tasks.length);
    }
}
