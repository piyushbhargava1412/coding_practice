package main.java.leetcode.easy;

import main.java.leetcode.common.TreeNode;

// https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 1, null, 1, null, 4, 2, null, 2, null};
        final TreeNode tree = TreeNode.createTree(nums, 0);
        System.out.println(isSymmetric(tree));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return checkMirror(root.left, root.right);
    }

    private static boolean checkMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        return n1.val == n2.val &&
                checkMirror(n1.left, n2.right) &&
                checkMirror(n1.right, n2.left);
    }
}
