public class Solution {
    public int countMinSquares(int A) {
        int[] dp = new int[A+1];
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min( min, dp[i - (j * j)]);
            }
            dp[i] = min + 1;
        }
        return dp[A];
    }
}
