package main.java.leetcode.medium;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        final ContiguousArray processor = new ContiguousArray();
        int[] input = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(processor.findMaxLength(input));
    }

    public int findMaxLength(int[] nums) {
        int targetSum = 0;
        final HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);
        int cumulativeSum = 0;
        int start = 0, end = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i] == 0 ? -1 : 1;

            // from start till current, if sum is targetSum
            if (cumulativeSum == targetSum) {
                start = 0;
                end = i;
                if (maxLen < end - start + 1) maxLen = end - start + 1;
            }
            // Y - X sub array
            else if (sumIndexMap.containsKey(cumulativeSum - targetSum)) {
                start = sumIndexMap.get(cumulativeSum - targetSum) + 1;
                end = i;
                if (maxLen < end - start + 1) maxLen = end - start + 1;
            }

            if (!sumIndexMap.containsKey(cumulativeSum))
                sumIndexMap.put(cumulativeSum, i);
        }
        return maxLen;
    }
}
