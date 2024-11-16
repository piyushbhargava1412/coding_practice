package main.java.leetcode.medium;

import main.java.leetcode.common.ListNode;

public class DeleteNodeInLinkList {
    public static void main(String[] args) {
        int [] nums = {4,5,1,9};
        final ListNode head = ListNode.createList(nums);
        int toBeDeleted = 5;
        ListNode ptr = head;
        while(ptr != null) {
            if(ptr.val == toBeDeleted) {
                deleteNode(ptr);
                break;
            }
            ptr = ptr.next;
        }
    }

    public static void deleteNode(ListNode node) {
        ListNode ptr = node;
        while(true) {
            int temp = ptr.val;
            ptr.val = ptr.next.val;
            ptr.next.val = temp;
            if(ptr.next.next == null) {
                ptr.next = null;
                break;
            }
            ptr = ptr.next;
        }
    }
}
