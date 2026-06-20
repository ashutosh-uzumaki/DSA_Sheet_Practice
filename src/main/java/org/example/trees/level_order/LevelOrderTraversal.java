package org.example.trees.level_order;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelTraversed = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null){
            return levelTraversed;
        }

        q.add(root);
        while(!q.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            int size = q.size();
            for(int i=size; i>0; i--){
                TreeNode curr = q.poll();
                currLevel.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            levelTraversed.add(new ArrayList<>(currLevel));
        }
        return levelTraversed;
    }
}
