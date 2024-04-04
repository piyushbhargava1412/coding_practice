package main.java.leetcode.easy;

// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/?envType=daily-question&envId=2024-04-04
public class MaxNestingDepth {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }

    public static int maxDepth(String s) {
        int maxOpenCnt = 0;
        int openCnt = 0;
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i) == '(') {
                openCnt++;
                maxOpenCnt = Math.max(maxOpenCnt, openCnt);
            }
            else if(s.charAt(i) == ')') openCnt--;
        }
        return maxOpenCnt;
    }
}
