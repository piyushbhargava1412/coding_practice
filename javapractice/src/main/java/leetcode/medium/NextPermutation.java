package main.java.leetcode.medium;

public class NextPermutation {
    public static void main(String[] args) {
        int [] nums = {2,3,1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;

        // base cases
        if(len == 1) return;
        if(len == 2) {
            reverseList(nums, 0, 1);
            return;
        }

        // if last two digits are in increasing order, swap them and return
        if(nums[len - 1] > nums[len - 2]) {
            int temp = nums[len - 1];
            nums[len - 1] = nums[len - 2];
            nums[len - 2] = temp;
            return;
        }

        // scan in reverse till we find nums[i - 1] < nums[i]
        for(int i = len - 1; i > 0; i--) {
            // if we find a case where nums[i - 1] < nums[i]
            // replace nums[i-1] with the next largest number in i to N
            // reverse the list between i to N
            if(nums[i - 1] < nums[i]) {
                int minIndex = len - 1;
                for(int j = len - 1;j >= i;j--) {
                    if(nums[j] > nums[i - 1]) {
                        minIndex = j;
                        break;
                    }
                }

                int temp = nums[minIndex];
                nums[minIndex] = nums[i - 1];
                nums[i - 1] = temp;
                reverseList(nums, i, len - 1);
                return;
            }
        }

        // if entire array is already in descending order, then reverse the list
        reverseList(nums, 0, len - 1);
        return;
    }

    private static void reverseList(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Move towards the center
            start++;
            end--;
        }
    }
}
