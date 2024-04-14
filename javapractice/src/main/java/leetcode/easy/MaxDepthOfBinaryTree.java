package main.java.leetcode.easy;

import main.java.leetcode.common.TreeNode;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        final TreeNode tree = TreeNode.createTree(nums, 0);
        System.out.println(maxDepth(tree));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return recursive(root, 1);
    }

    private static int recursive(TreeNode node, int currDepth) {
        int leftDepth = node.left != null ? recursive(node.left, currDepth + 1) : currDepth;
        int rightDepth = node.right != null ? recursive(node.right, currDepth + 1) : currDepth;
        return Math.max(leftDepth,rightDepth);
    }
}
