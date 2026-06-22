package org.example.trees.pre_order;

import java.util.*;

public class AllPathsInBT {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper ("", root, ans);
        return ans;
    }

    private void helper(String path, TreeNode root, List<String> ans){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            path += root.val;
            ans.add(path);
            return;
        }

        helper(path+root.val+"->", root.left, ans);
        helper(path+root.val+"->", root.right, ans);
    }
}
