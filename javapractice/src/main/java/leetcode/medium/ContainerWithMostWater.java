package main.java.leetcode.medium;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        final ContainerWithMostWater processor = new ContainerWithMostWater();
        int []nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(processor.maxArea(nums));
    }

    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while(left < right) {
            int ht = (heights[left] < heights[right]) ? heights[left] : heights[right];
            int area = ht * (right - left);
            if(maxArea < area) maxArea = area;
            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
