package org.example.trees.dfs;

public class MaximumDiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        maxDiameter[0] = Integer.MIN_VALUE;
        helper(root, maxDiameter);
        return maxDiameter[0] - 1;
    }

    private int helper(TreeNode root, int[] maxDiameter){
        if(root == null){
            return 0;
        }

        int leftDiameter = helper(root.left, maxDiameter);
        int rightDiameter = helper(root.right, maxDiameter);

        maxDiameter[0] = Math.max(maxDiameter[0], leftDiameter + rightDiameter + 1);

        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
