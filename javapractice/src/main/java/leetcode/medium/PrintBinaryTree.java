package main.java.leetcode.medium;

import main.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {

    public static void main(String[] args) {
        Integer [] nums = {1,2,3,null,4};
        System.out.println(printTree(TreeNode.createTree(nums, 0)));
    }

    public static List<List<String>> printTree(TreeNode root) {
        int height = height(root) - 1;
        System.out.println(height);
        int m = height + 1;
        int n = (int)(Math.pow(2, m) - 1);
        String [][] matrix = new String[m][n];
        recursion(root, matrix, 0,(n-1)/2, height);

        List<List<String>> printed = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            final List<String> row = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == null)
                    row.add("");
                else row.add(matrix[i][j]);

            }
            printed.add(row);
        }
        return printed;
    }

    private static int height(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static void recursion(TreeNode node, String [][] matrix, int r, int c, int height) {
        if(node == null) return;
        matrix[r][c] = String.valueOf(node.val);
        recursion(node.left, matrix, r + 1, c - (int)Math.pow(2, height - r - 1), height);
        recursion(node.right, matrix, r + 1, c + (int)Math.pow(2, height - r - 1), height);
    }
}
