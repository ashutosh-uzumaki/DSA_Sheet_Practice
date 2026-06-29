package org.example.trees.dfs;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        return validateHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateHelper(TreeNode root, long low, long high){
        if(root == null){
            return true;
        }

        if(root.val <= low || root.val >= high){
            return false;
        }

        boolean leftChildValidation = validateHelper(root.left, low, root.val);
        boolean rightChildValidation = validateHelper(root.right, root.val, high);

        return leftChildValidation && rightChildValidation;
    }
}
