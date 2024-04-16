package main.java.leetcode.easy;

import main.java.leetcode.common.TreeNode;

public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
//        Integer[] nums = {3,9,20,null,null,15,7};
        Integer[] nums = {2,null,3,null,4,null,5,null,6};
        final TreeNode tree = TreeNode.createTree(nums, 0);
        System.out.println(minDepth(tree));
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        return recursive(root, 1);
    }

    private static int recursive(TreeNode node, int currDepth) {
        if(node.left == null && node.right == null) return currDepth;
        if(node.left == null) return recursive(node.right, currDepth + 1);
        if(node.right == null) return recursive(node.left, currDepth + 1);

        int leftDepth = recursive(node.left, currDepth + 1);
        int rightDepth = recursive(node.right, currDepth + 1);
        return Math.min(leftDepth,rightDepth);
    }
}
