package org.example.trees.pre_order;

public class ConvertArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }

        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }

        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int low, int high){
        if(low >= high){
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid);
        root.right = helper(nums, mid + 1, high);

        return root;
    }
}
