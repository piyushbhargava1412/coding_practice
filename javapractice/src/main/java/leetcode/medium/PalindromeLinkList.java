package main.java.leetcode.medium;

import main.java.leetcode.common.ListNode;

public class PalindromeLinkList {

    public static void main(String[] args) {
        final PalindromeLinkList processor = new PalindromeLinkList();
        int[] nums = {1, 1, 2, 1};
        System.out.println(processor.isPalindrome(ListNode.createList(nums)));
    }

    public boolean isPalindrome(ListNode head) {
//        return isPalindromeUsingString(head);
        return isPalindromeUsingReverseList(head);
    }

    private boolean isPalindromeUsingReverseList(ListNode head) {
        ListNode originalHead = head;
        ListNode reverseHead = reverseLinkedList(head);
        ListNode ptr1 = originalHead;
        ListNode ptr2 = reverseHead;
        int len = len(originalHead);

        for(int i = 0;i < len/2;i++) {
            if(ptr1.val != ptr2.val) return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode node = new ListNode(curr.val, prev);
            prev = node;
            curr = curr.next;
        }
        return prev;
    }

    private int len(ListNode head) {
        if(head == null) return 0;
        int n = 1;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            n++;
        }
        return n;
    }

    private boolean isPalindromeUsingString(ListNode head) {
        ListNode curr = head;
        final StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val);
            curr = curr.next;
        }

        String string = sb.toString();
        int len = string.length();
        for (int i = 0; i < len / 2; i++) {
            if (string.charAt(i) != string.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
