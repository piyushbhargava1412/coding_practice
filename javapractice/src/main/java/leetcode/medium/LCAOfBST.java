package main.java.leetcode.medium;

import main.java.leetcode.common.TreeNode;
public class LCAOfBST {

    public static void main(String[] args) {
//        Integer [] nums = {6,2,8,0,4,7,9,null,null,3,5};
        Integer [] nums = {2,1};
        final TreeNode tree = TreeNode.createTree(nums, 0);
        final TreeNode treeNode = lowestCommonAncestor(tree, tree, tree.left);
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            return recursive(root, q, p);
        } else return recursive(root, p, q);
    }

    private static TreeNode recursive(TreeNode node, TreeNode low, TreeNode high) {
        if(node.val >= low.val && node.val <= high.val) return node;
        if(node.val > low.val && node.val > high.val) return recursive(node.left, low, high);
        else return recursive(node.right, low, high);
    }
}
