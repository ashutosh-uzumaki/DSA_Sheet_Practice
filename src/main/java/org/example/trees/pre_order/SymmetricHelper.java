package org.example.trees.pre_order;

public class SymmetricHelper {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val && isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
    }
}
