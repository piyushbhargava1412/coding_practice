package main.java.leetcode.medium;

import main.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        Integer []nums = {1,2,3,null,5,null,4};
        System.out.println(rightSideView(TreeNode.createTree(nums, 0)));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        // create a levelWiseQueue
        final LinkedList<TreeNode> levelWiseQ = new LinkedList<>();
        // start from root
        levelWiseQ.add(root);
        // while queue is not empty
        while(!levelWiseQ.isEmpty()) {
            int numNodes = levelWiseQ.size();
            // for each node in the current level, add its left and then right
            for(int i = 0; i < numNodes; i++) {
                final TreeNode node = levelWiseQ.poll();
                // at each iteration pick the right most node val (last in the queue)
                if(i == numNodes - 1) {
                    if(node != null) result.add(node.val);
                }

                if(node.left != null) levelWiseQ.add(node.left);
                if(node.right != null) levelWiseQ.add(node.right);
            }
        }

        return result;
    }
}
