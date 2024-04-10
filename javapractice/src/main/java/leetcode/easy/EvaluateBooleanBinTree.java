package main.java.leetcode.easy;

// https://leetcode.com/problems/evaluate-boolean-binary-tree/description/
public class EvaluateBooleanBinTree {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean evaluateTree(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return root.val == 1 ? true : false;

        boolean leftValue = evaluateTree(root.left);
        boolean rightValue = evaluateTree(root.right);

        return (root.val == 2) ? leftValue || rightValue : leftValue && rightValue;
    }
}
