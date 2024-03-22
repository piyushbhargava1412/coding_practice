package main.java.leetcode.medium.DP;

//https://leetcode.com/problems/edit-distance/
public class EditDistance {

  public static void main(String[] args) {
    EditDistance processor = new EditDistance();
    System.out.println(processor.minDistance("intention", "execution"));
  }

  public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    int[][] dp = new int[n + 1][m + 1];

    if (n == 0) return m;
    if (m == 0) return n;

    // base case
    for (int i = 0; i <= n; i++) dp[i][0] = i;
    for (int j = 0; j <= m; j++) dp[0][j] = j;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] =
          dp[i - 1][j - 1]; else {
          dp[i][j] =
            1 +
            min(
              dp[i][j - 1], // Insert
              dp[i - 1][j], // Remove
              dp[i - 1][j - 1] // Replace
            );
        }
      }
    }
    return dp[n][m];
  }

  private int min(int x, int y, int z) {
    if (x < y && x < z) return x;
    if (y < x && y < z) return y;
    return z;
  }
}
