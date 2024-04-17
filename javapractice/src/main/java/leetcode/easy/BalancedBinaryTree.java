package main.java.leetcode.easy;

import main.java.leetcode.common.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Integer [] nums = {1,2,2,3,3,null,null,4,4};
        System.out.println(isBalanced(TreeNode.createTree(nums, 0)));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int delta = Math.abs(height(root.left) - height(root.right));
        if(delta > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
