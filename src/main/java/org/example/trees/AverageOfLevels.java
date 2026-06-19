package org.example.trees;

import java.util.*;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            int size = treeNodes.size();
            Double currLevelAvg = 0.0;
            for(int i=0; i<size; i++){
                TreeNode curr = treeNodes.remove();
                currLevelAvg += curr.val;
                if(curr.left != null){
                    treeNodes.add(curr.left);
                }
                if(curr.right != null){
                    treeNodes.add(curr.right);
                }
            }
            currLevelAvg /= size;
            averages.add(currLevelAvg);
        }
        return averages;
    }
}
