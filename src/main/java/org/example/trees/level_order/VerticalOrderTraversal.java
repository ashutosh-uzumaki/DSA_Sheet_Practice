package org.example.trees.level_order;

import java.util.*;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> colMap = new TreeMap<>();

        Queue<NodeMeta> queue = new ArrayDeque<>();
        queue.offer(new NodeMeta(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeMeta curr = queue.poll();

            colMap.computeIfAbsent(curr.col, k -> new TreeMap<>())
                    .computeIfAbsent(curr.row, k -> new ArrayList<>())
                    .add(curr.node.val);

            if (curr.node.left != null) {
                queue.offer(new NodeMeta(curr.node.left, curr.row + 1, curr.col - 1));
            }
            if (curr.node.right != null) {
                queue.offer(new NodeMeta(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> rowMap : colMap.values()) {
            List<Integer> colValues = new ArrayList<>();
            for (List<Integer> nodesAtPosition : rowMap.values()) {
                Collections.sort(nodesAtPosition);
                colValues.addAll(nodesAtPosition);
            }
            result.add(colValues);
        }

        return result;
    }

    private static class NodeMeta {
        TreeNode node;
        int row;
        int col;

        NodeMeta(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
