package main.java.leetcode.easy;

// https://leetcode.com/problems/make-the-string-great/description/?envType=daily-question&envId=2024-04-05
public class GoodString {

    public static void main(String[] args) {
        System.out.println(makeGood("s"));
    }
    public static String makeGood(String s) {
        if(s.length() == 1) return s;
        final int abs = Math.abs(s.charAt(0) - s.charAt(1));
        if(s.length() == 2 && abs != 32) return s;
        if(s.length() == 2 && abs == 32) return "";

        int index = findPatternStartIndex(s);
        while(index != -1) {
            s = s.substring(0, index) + s.substring(index + 2);
            index = findPatternStartIndex(s);
        }
        return s;
    }

    private static int findPatternStartIndex(String s) {
        for(int i = 0;i < s.length() - 1;i++) {
            if(Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) return i;
        }
        return -1;
    }
}
