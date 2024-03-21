package main.java.leetcode.medium;

import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) return 1;
            return 2;
        }
        final HashSet<Character> set = new HashSet<>();
        int l = 0;
        int maxLen = 0;
        set.add(s.charAt(l));
        for (int r = 1; r < s.length(); r++) {
            final char rChar = s.charAt(r);
            while (set.contains(rChar)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(rChar);
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }
}
