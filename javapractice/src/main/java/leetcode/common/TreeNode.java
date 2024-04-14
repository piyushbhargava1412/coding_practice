package main.java.leetcode.common;

import lombok.Getter;

// Definition for a binary tree node.
public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     public static TreeNode createTree(Integer [] nums, int i) {
         if(i >= nums.length) return null;
         if(nums[i] == null) return null;

         TreeNode root = new TreeNode(nums[i]);
         root.left = createTree(nums, 2*i + 1);
         root.right = createTree(nums, 2*i + 2);

         return root;
     }
 }

