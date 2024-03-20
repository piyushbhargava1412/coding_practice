package main.java.leetcode.medium;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        final AddTwoNumbers processor = new AddTwoNumbers();
        int [] list1 = {9,9,9,9,9,9,9};
        int [] list2 = {9,9,9,9};
        System.out.println(processor.addTwoNumbers(createList(list1), createList(list2)));
    }

    public static ListNode createList(int [] nums) {
        ListNode head = new ListNode(nums[0], null);
        ListNode curr = head;
        for(int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i], null);
            curr = curr.next;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null) return l2;
        if(l2 == null && l1 != null) return l1;
        if(l1.val == 0 && l1.next == null && l2 != null) return l2;
        if(l2.val == 0 && l2.next == null && l1 != null) return l1;

        ListNode output = null;
        int carryForward = 0;
        int sum = l1.val + l2.val;
        if(sum < 10)
            output = new ListNode(sum, null);
        else {
            output = new ListNode(sum % 10, null);
            carryForward = 1;
        }
        ListNode head = output;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            sum = l1.val + l2.val + carryForward;
            if (sum < 10) {
                output.next = new ListNode(sum, null);
                carryForward = 0;
            } else {
                output.next = new ListNode(sum % 10, null);
                carryForward = 1;
            }
            output = output.next;
        }

        l1 = (l1.next == null) ? l2 : l1;

        if(l1.next != null) {
            while(l1.next != null) {
                l1 = l1.next;
                sum = l1.val + carryForward;
                if (sum < 10) {
                    output.next = new ListNode(sum, null);
                    carryForward = 0;
                } else {
                    output.next = new ListNode(sum % 10, null);
                    carryForward = 1;
                }
                output = output.next;
            }
        }

        if(carryForward > 0) {
            output.next = new ListNode(carryForward, null);
        }

        return head;
    }
}
