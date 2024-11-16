package main.java.leetcode.easy;

import main.java.leetcode.common.TreeNode;

public class DiameterOfBST {
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Integer [] nums = {-10,9,20,null,null,15,7};
        System.out.println(diameterOfBinaryTree(TreeNode.createTree(nums, 0)));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return maxSum - 1;
    }

    private static int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate maximum sum paths from left and right subtrees
        int leftSum = Math.max(0, recursion(node.left));
        int rightSum = Math.max(0, recursion(node.right));

        // Update maximum sum if the current node is part of the maximum sum path
        maxSum = Math.max(maxSum, 1 + leftSum + rightSum);

        // Return the maximum sum path starting from the current node
        return 1 + leftSum + rightSum;
    }
}
