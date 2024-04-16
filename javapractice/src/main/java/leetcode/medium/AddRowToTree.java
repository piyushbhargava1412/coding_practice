package main.java.leetcode.medium;

import main.java.leetcode.common.TreeNode;

// https://leetcode.com/problems/add-one-row-to-tree/description/?envType=daily-question&envId=2024-04-16
public class AddRowToTree {

    public static void main(String[] args) {
        Integer[] nums = {4,2,6,3,1,5};
        addOneRow(TreeNode.createTree(nums, 0), 1, 1);
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            return new TreeNode(1, root, null);
        }
        recursive(root, val, depth, 1);
        return root;
    }

    private static void recursive(TreeNode node, int val, int depth, int curDepth) {
        if (node == null) return;

        if (curDepth < depth - 1) {
            recursive(node.left, val, depth, curDepth + 1);
            recursive(node.right, val, depth, curDepth + 1);
        }
        if (curDepth == depth - 1) {
            TreeNode leftSubtree = node.left;
            TreeNode rightSubtree = node.right;
            node.left = new TreeNode(val, leftSubtree, null);
            node.right = new TreeNode(val, null, rightSubtree);
        }
    }
}
