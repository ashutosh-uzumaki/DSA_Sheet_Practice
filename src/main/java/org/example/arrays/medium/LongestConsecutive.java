package org.example.arrays.medium;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        HashSet<Integer> seqSet = new HashSet<>();
        for(int num: nums){
            seqSet.add(num);
        }
        int longestSeq = 1;
        for(int num: seqSet){
            if(!seqSet.contains(num - 1)){
                int currSeq = 1;
                int nextSeqNum = num + 1;
                while(seqSet.contains(nextSeqNum)){
                    currSeq += 1;
                    nextSeqNum += 1;
                }
                longestSeq = Math.max(longestSeq, currSeq);
            }
        }

        return longestSeq;
    }
}
