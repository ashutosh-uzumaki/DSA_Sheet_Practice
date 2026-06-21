package org.example.trees.pre_order;

import java.util.*;



public class TraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            ans.add(curr.val);
            if(curr.right != null)stack.push(curr.right);
            if(curr.left != null)stack.push(curr.left);
        }
        return ans;
    }
}
