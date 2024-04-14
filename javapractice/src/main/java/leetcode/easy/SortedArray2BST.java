package main.java.leetcode.easy;

import main.java.leetcode.common.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class SortedArray2BST {
    public static void main(String[] args) {
        int [] nums = {-10,-3,0,5,9};
        final TreeNode bst = sortedArrayToBST(nums);
        return;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1) return new TreeNode(nums[0], null, null);
        return recursive(nums, 0, nums.length - 1);
    }

    private static TreeNode recursive(int[] nums, int start, int end) {
        if(start > end) return null;

        int mid = (start + end) / 2;
        final TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = recursive(nums, start, mid-1);
        treeNode.right = recursive(nums, mid+1,end);
        return treeNode;
    }
}
