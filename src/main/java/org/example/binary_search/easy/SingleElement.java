package org.example.binary_search.easy;

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            boolean moveLeft = (mid % 2 == 0 && (nums[mid] == nums[mid + 1]));
            moveLeft = moveLeft || (mid % 2 == 1 && (nums[mid] == nums[mid - 1]));

            if(moveLeft){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
