package main.java.leetcode.hard;

import java.util.HashSet;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        final HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] <= 0) continue;
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if(min > 1) return 1;
        int i;
        for(i = min + 1;i <= max; i++) {
            if(!set.contains(i)) return i;
        }
        return max + 1;
    }
}
