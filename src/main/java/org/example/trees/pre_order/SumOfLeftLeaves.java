package org.example.trees.pre_order;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] totalSum = new int[1];
        helper(root, totalSum);
        return totalSum[0];
    }

    private void helper(TreeNode root, int[] totalSum){
        if(root == null){
            return;
        }

        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                totalSum[0] += root.left.val;
            }
        }

        helper(root.left, totalSum);
        helper(root.right, totalSum);
    }
}
