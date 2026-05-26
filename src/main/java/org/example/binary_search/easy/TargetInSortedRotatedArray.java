package org.example.binary_search.easy;

public class TargetInSortedRotatedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int findMinElementIdx = findMinElement(nums);
            if(findMinElementIdx == 0){
                return searchHelper(nums, target, 0, nums.length - 1);
            }
            int findIdx = searchHelper(nums, target, 0, findMinElementIdx - 1);
            if(findIdx != -1){
                return findIdx;
            }
            return searchHelper(nums, target, findMinElementIdx, nums.length - 1);
        }

        private int findMinElement(int[] nums){

            int low = 0;
            int high = nums.length - 1;
            int n = nums.length;

            if(nums[0] <= nums[n - 1]){
                return 0;
            }

            while(low < high){
                int mid = low + (high - low) / 2;
                if(nums[mid] > nums[high]){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }

            return low;
        }

        private int searchHelper(int[] nums, int target, int low, int high){
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return -1;
        }
    }
}
