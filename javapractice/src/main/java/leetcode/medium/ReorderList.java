package main.java.leetcode.medium;

import main.java.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        final ReorderList processor = new ReorderList();
        int [] nums = {1,2,3,4,5};
        processor.reorderList(ListNode.createList(nums));
    }

    public void reorderList(ListNode head) {
        ListNode curr = head;
        final List<ListNode> listNodes = new ArrayList<>();
        while(curr != null) {
//            System.out.println(curr.val);
            listNodes.add(curr);
            curr = curr.next;
        }

        final int N = listNodes.size();
        if(N <= 2) return;

        for(int i = 0; i < listNodes.size()/2; i++) {
            ListNode temp = listNodes.get(i).next;
            listNodes.get(i).next = listNodes.get(N - 1 - i);
            listNodes.get(N - 1 - i).next = temp;
        }
        listNodes.get(listNodes.size()/2).next = null;
//
//        curr = head;
//        while(curr != null) {
//            System.out.println(curr.val);
//            curr = curr.next;
//        }
    }
}
