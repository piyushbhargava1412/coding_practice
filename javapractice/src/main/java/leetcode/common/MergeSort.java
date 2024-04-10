package main.java.leetcode.common;

public class MergeSort {
    public static void main(String[] args) {
        int [] nums = {13, 10, 9, 1, 3, 5, 4, 6, 8, 15, 17};

        int [] tempNums = new int[nums.length];
        mergeSort(nums, tempNums, 0, nums.length-1);

        for(int i = 0;i < nums.length;i++) {
            System.out.print(nums[i] + ",");
        }
    }

    private static void mergeSort(int[] nums, int[] tempNums, int left, int right) {
        int mid = (right + left)/2;

        if(left != right) {
            mergeSort(nums, tempNums, left, mid);
            mergeSort(nums, tempNums, mid + 1, right);

            merge(nums, tempNums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int[] tempNums, int left, int mid, int right) {
        for(int i = left;i <= right;i++) {
            tempNums[i] = nums[i];
        }

        int i = left;
        int k = left;
        int j = mid + 1;

        while(i <= mid && j <= right) {
            if(tempNums[i] <= tempNums[j]) {
                nums[k] = tempNums[i];
                i++;
            } else {
                nums[k] = tempNums[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            nums[k] = tempNums[i];
            i++;
            k++;
        }

        while(j <= right) {
            nums[k] = tempNums[j];
            j++;
            k++;
        }
    }
}
