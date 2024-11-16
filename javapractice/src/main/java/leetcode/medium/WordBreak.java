package main.java.leetcode.medium;

import java.util.*;

public class WordBreak {
    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        // Convert the list to a set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        // a map for memoization of the segment-able statuses of all possible substrings
        Map<String, Boolean> memo = new HashMap<>();

        return recHelper(s, wordSet, memo);
    }

    private boolean recHelper(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        // Base case: empty string
        if(s.isEmpty()) return true;

        // if the result for the substring is stored, return that
        if(memo.containsKey(s)) return memo.get(s);

        // for the given string s, find the point i such that s[0:i] and s[i:len] are segment-able
        for(int i = 1 ; i <= s.length() ; i++) {
            String subStr = s.substring(0, i);
            // if s[0:i] is in dictionary and the recursive call for s[i:len] returns true as well
            if(wordSet.contains(subStr) && recHelper(s.substring(i), wordSet, memo)) {
                // then the input string "s" to this method call is segment-able
                memo.put(s, true);
                return true;
            }
        }

        // if we did not find any such s[0:i] and s[i:len] pair, then set this to false
        memo.put(s, false);
        return false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        // Convert the list to a set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // Base case: empty string
        dp[0] = true;

        // run a loop for the length of the string
        // at the end of the loop when i == n, we would have explored all possible s[0:j] and s[j:i] such that
        // if dp[n] is true, then the input string is segment-able
        for (int i = 1; i <= s.length(); i++) {

            // For each position i, this loop considers all possible starting positions
            // j for the substring that ends at position i, i.e. s[j:i]
            for (int j = 0; j < i; j++) {
                System.out.println("i=" + i + " j=" + j + " substring=" + s.substring(j, i));
                // further, the inner loop is finding that j for which, s[0:j] and s[j:i] both are present in the dictionary
                // s[0:j] is present can be determined by looking at dp[j]
                // and s[j:i] can now be searched in the dictionary if d[j] is true
                // if s[0:j] is segment-able and s[j:i] is in dictionary, then s[0:i] is segment able
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    System.out.println(s.substring(0, i) + " is segment-able in " + s.substring(0, j) + " and " + s.substring(j, i));
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        // Example usage
        String s1 = "leetcode";
        List<String> wordDict1 = List.of("leet", "code");
//        System.out.println(wb.wordBreakDP(s1, wordDict1));  // Output: true
        System.out.println(wb.wordBreakRecursive(s1, wordDict1));  // Output: true

        String s2 = "applepenapple";
        List<String> wordDict2 = List.of("apple", "pen");
//        System.out.println(wb.wordBreakDP(s2, wordDict2));  // Output: true
        System.out.println(wb.wordBreakRecursive(s2, wordDict2));  // Output: true

        String s3 = "catsandog";
        List<String> wordDict3 = List.of("cats", "dog", "sand", "and", "cat");
//        System.out.println(wb.wordBreakDP(s3, wordDict3));  // Output: false
        System.out.println(wb.wordBreakRecursive(s3, wordDict3));  // Output: false
    }
}
