package main.java.leetcode.easy;

// https://leetcode.com/problems/length-of-last-word/description/
public class LastWordLength {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" hello"));
    }

    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int i = len - 1;
        if(s.charAt(i) == ' ') {
            while(s.charAt(i) == ' ') i--;
        }

        if(len == 1) return 1;

        int size = 0;
        while(s.charAt(i) != ' ' && i > 0) {
            i--;
            size++;
        }
        if(i == 0 && s.charAt(i) != ' ') size++;
        return size;
    }
}
