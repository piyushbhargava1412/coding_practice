package main.java.leetcode.common;

public class ListNode {

  public int val;
  public ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode createList(int[] nums) {
    ListNode head = new ListNode(nums[0], null);
    ListNode curr = head;
    for (int i = 1; i < nums.length; i++) {
      curr.next = new ListNode(nums[i], null);
      curr = curr.next;
    }
    return head;
  }

  public static int len(ListNode head) {
    if(head == null) return 0;
    int n = 1;
    ListNode curr = head;
    while(curr != null) {
      curr = curr.next;
      n++;
    }
    return n;
  }
}
