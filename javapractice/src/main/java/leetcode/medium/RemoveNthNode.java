package main.java.leetcode.medium;

import main.java.leetcode.common.ListNode;

public class RemoveNthNode {

  public static void main(String[] args) {
    final RemoveNthNode processor = new RemoveNthNode();
    int[] nums = { 1, 2 };
    System.out.println(
      processor.removeNthFromEnd(ListNode.createList(nums), 2)
    );
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode curr = head;
    ListNode prev = null;
    int numNodes = 1;
    while (curr.next != null) {
      prev = curr;
      curr = curr.next;
      numNodes++;
    }

    if (numNodes == 1) return null;
    if (n == 1) {
      prev.next = null;
      return head;
    }
    if (n == numNodes) {
      head = head.next;
      return head;
    }

    curr = head;
    prev = null;
    for (int i = 0; i < numNodes; i++) {
      if (i == numNodes - n) {
        prev.next = curr.next;
        curr = curr.next;
      }
      if (curr == null) break;
      prev = curr;
      curr = curr.next;
    }
    return head;
  }
}
