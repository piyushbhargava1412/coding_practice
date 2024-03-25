package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {

    public static void main(String[] args) {
        final FindDuplicate processor = new FindDuplicate();
        int [] nums = {3,1,3,4,2};
        System.out.println(processor.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int nextIndex = nums[0];
        for(int i = 1; i < nums.length;i++) {
            int temp = nums[nextIndex];
            if(nums[nextIndex] == -1) break;
            nums[nextIndex] = -1;
            nextIndex = temp;
        }
        return nextIndex;
    }
}
