package org.example.stacks;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }
        int totalAmountStored = 0;
        for(int i=0; i<n; i++){
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];

            int minHeight = Math.min(leftMax, rightMax);
            int currentWater = minHeight - height[i];
            totalAmountStored += currentWater;
        }

        return totalAmountStored;
    }
}
