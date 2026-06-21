package org.example.trees.level_order;

import java.util.*;

public class CompletenessOfBT {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                foundNull = true;
            } else {
                if (foundNull) {
                    return false; // Encountered a non-null node after a null
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}
