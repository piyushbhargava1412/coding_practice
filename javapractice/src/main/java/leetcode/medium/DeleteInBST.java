package main.java.leetcode.medium;

import main.java.leetcode.common.TreeNode;

import java.util.List;

public class DeleteInBST {

    public static void main(String[] args) {
        Integer [] nums = {5,3,6,2,4,null,7};
        TreeNode tree = TreeNode.createTree(nums, 0);
        tree = deleteNode(tree, 3);
        System.out.println(PrintBinaryTree.printTree(tree));
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private static int findMin(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }
}
