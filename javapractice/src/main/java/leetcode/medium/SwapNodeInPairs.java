package main.java.leetcode.medium;

import main.java.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwapNodeInPairs {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        swapPairs(ListNode.createList(nums));
    }
    public static ListNode swapPairs(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        if(nodes.size() <= 1) return head;

        for(int i = 0; i < nodes.size(); i++) {
            if((i + 1) % 2 == 0) {
                nodes.get(i).next = nodes.get(i - 1);
            } else if( (i + 1) % 2 != 0){
                if(i + 3 < nodes.size())
                    nodes.get(i).next = nodes.get(i + 3);
                else if(i + 3 == nodes.size()) {
                    nodes.get(i).next = nodes.get(nodes.size() - 1);
                } else nodes.get(i).next = null;
            }
        }
        return nodes.get(1);
    }
}
