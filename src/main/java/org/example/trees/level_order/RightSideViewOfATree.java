package org.example.trees.level_order;

import java.util.*;

public class RightSideViewOfATree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        if(root == null){
            return rightSide;
        }

        nodes.add(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for(int i=0; i<size; i++){
                TreeNode currNode = nodes.remove();
                if(i == size - 1){
                    rightSide.add(currNode.val);
                }
                if(currNode.left != null){
                    nodes.add(currNode.left);
                }
                if(currNode.right != null){
                    nodes.add(currNode.right);
                }
            }
        }
        return rightSide;
    }
}
