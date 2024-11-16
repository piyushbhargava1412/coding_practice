package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarray {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // Map to store cumulative sum and list of indices where the sum occurs
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        // List to store the result subarrays
        List<int[]> result = new ArrayList<>();
        // Initialize cumulative sum
        int cumulativeSum = 0;

        // Initialize the map with cumulative sum 0 occurring at index -1
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            cumulativeSum += arr[i];

            // If the cumulative sum has been seen before
            if (sumMap.containsKey(cumulativeSum)) {
                // Get all indices where this cumulative sum has occurred
                List<Integer> indices = sumMap.get(cumulativeSum);
                // Add all subarrays ending at the current index and starting after previous indices
                for (int index : indices) {
                    result.add(getSubarray(arr, index + 1, i));
                }
            }

            // Add the current index to the list of indices for this cumulative sum
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    // Helper method to get a subarray from an array given start and end indices
    private static int[] getSubarray(int[] arr, int start, int end) {
        int[] subarray = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            subarray[i - start] = arr[i];
        }
        return subarray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -1, -3, 2, 3};
        List<int[]> subarrays = findZeroSumSubarrays(arr);
        for (int[] subarray : subarrays) {
            System.out.println(arrayToString(subarray));
        }
    }

    // Helper method to convert array to string for printing
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
