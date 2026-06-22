package org.example.trees.pre_order;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeHelper(p, q);
    }

    private boolean isSameTreeHelper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val && isSameTreeHelper(p.left,  q.left) && isSameTreeHelper(p.right, q.right);
    }
}
