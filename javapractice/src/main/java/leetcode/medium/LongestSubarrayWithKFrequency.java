package main.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/?envType=daily-question&envId=2024-03-28
public class LongestSubarrayWithKFrequency {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3};
        System.out.println(maxSubarrayLength(nums, 2));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        int l = 0;
        frequency.put(nums[l], 1);
        int maxLen = 1;
        for (int r = 1; r < nums.length; r++) {
            final Integer currFreq = frequency.get(nums[r]);
            if (currFreq == null) {
                frequency.put(nums[r], 1);
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                frequency.put(nums[r], currFreq + 1);
                if (currFreq + 1 <= k) {
                    maxLen = Math.max(maxLen, r - l + 1);
                } else {
                    maxLen = Math.max(maxLen, r - l);
                    frequency.put(nums[l], frequency.get(nums[l]) - 1);
                    while (l < r - 1 && nums[l] != nums[r]) {
                        l++;
                        frequency.put(nums[l], frequency.get(nums[l]) - 1);
                        if (nums[l] == nums[r]) break;
                    }
                    l++;
                }
            }
        }
        return maxLen;
    }
}
