package main.java.leetcode.medium;

import main.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=daily-question&envId=2024-04-15
public class SumRootToLeaf {

    public static void main(String[] args) {
        Integer[] nums = {4, 9, 0, 5, 1};
        System.out.println(sumNumbers(TreeNode.createTree(nums, 0)));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return generateNumericString(root, String.valueOf(root.val));
    }

    private static int generateNumericString(TreeNode node, String draft) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return Integer.parseInt(draft);
        }

        int leftsum = 0;
        int rightsum = 0;
        if (node.left != null) leftsum = generateNumericString(node.left, draft + node.left.val);
        if (node.right != null) rightsum = generateNumericString(node.right, draft + node.right.val);
        return leftsum + rightsum;
    }
}
