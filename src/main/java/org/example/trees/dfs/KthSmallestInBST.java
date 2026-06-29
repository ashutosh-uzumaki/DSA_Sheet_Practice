package org.example.trees.dfs;

public class KthSmallestInBST {
    int ans = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root, k);
        return ans;
    }

    public void helper(TreeNode root, int k){
        if(root == null){
            return;
        }

        helper(root.left, k);
        count--;
        if(count == 0){
            ans = root.val;
            return;
        }
        helper(root.right, k);
    }
}
