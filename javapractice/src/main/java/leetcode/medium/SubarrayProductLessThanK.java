package main.java.leetcode.medium;

// https://leetcode.com/problems/subarray-product-less-than-k/description/?envType=daily-question&envId=2024-03-27
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
        int[] nums = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0, count = 0;
        long product = 1;
        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            count = count + (right - left + 1);
        }

        return count;
    }
}
