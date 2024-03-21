package main.java.leetcode.medium;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        final LongestPalindromeSubstring processor = new LongestPalindromeSubstring();
        System.out.println(processor.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;

        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            final int[] oddPalindromeOffsets = findPalindromeOffsets(i - 1, i + 1, s);
            if (maxLen < oddPalindromeOffsets[1]) {
                start = oddPalindromeOffsets[0];
                maxLen = oddPalindromeOffsets[1];
            }

            int[] evenPalindromeOffsets = findPalindromeOffsets(i, i + 1, s);
            if (maxLen < evenPalindromeOffsets[1]) {
                start = evenPalindromeOffsets[0];
                maxLen = evenPalindromeOffsets[1];
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int[] findPalindromeOffsets(int l, int r, String s) {
        int[] result = new int[2];
        int maxLen = 1;
        int start = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > maxLen) {
                start = l;
                maxLen = r - l + 1;
            }
            l--;
            r++;
        }
        result[0] = start;
        result[1] = maxLen;
        return result;
    }
}
