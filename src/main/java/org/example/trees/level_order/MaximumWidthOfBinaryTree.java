package org.example.trees.level_order;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth = Integer.MIN_VALUE;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int firstIndex = queue.peek().index;
            int lastIndex = firstIndex;
            for(int i=0; i<size; i++){
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                int index = curr.index - firstIndex;
                lastIndex = index;

                if(node.left != null){
                    queue.offer(new Pair(node.left, 2 * index));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right, 2 * index + 1));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex - 0 + 1);
        }

        return maxWidth;
    }

    private static class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
}
