package main.java.leetcode.hard;

import main.java.leetcode.common.TreeNode;

public class BinaryTreeMaxPathSum {
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Integer [] nums = {-10,50,20,null,null,15,7};
        System.out.println(maxPathSum(TreeNode.createTree(nums, 0)));
    }

    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private static int maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate maximum sum paths from left and right subtrees
        int leftSum = Math.max(0, maxPathSumHelper(node.left));
        int rightSum = Math.max(0, maxPathSumHelper(node.right));

        // Update maximum sum if the current node is part of the maximum sum path
        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);

        // Return the maximum sum path starting from the current node
        return node.val + leftSum + rightSum;
    }
}
