package main.java.leetcode.medium.DP;

// https://leetcode.com/problems/count-sorted-vowel-strings/description/
public class CountSortedVowelString {

  public static void main(String[] args) {
    CountSortedVowelString processor = new CountSortedVowelString();
    System.out.println(processor.countVowelStrings(33));
  }

  public int countVowelStrings(int n) {
    int[][] dp = new int[n + 1][6];
    for (int j = 1; j < 6; j++) dp[1][j] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= 5; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] + dp[n][5];
  }
}
