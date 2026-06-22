package org.example.trees.pre_order;

import java.util.*;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumhelper(root, targetSum, ans, path);
        return ans;
    }

    private void pathSumhelper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        pathSumhelper(root.left, targetSum - root.val, ans, path);
        pathSumhelper(root.right, targetSum - root.val, ans, path);
        path.remove(path.size() - 1);
    }
}
