public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 1];
        dp[1] = A[0];

        for ( int i = 1; i <= n; i++ ) {
            for ( int j = 1; j <= i; j++ ) {
                dp[i] = Math.max(dp[i], A[j-1] + dp[i - j]);
            }
        }
        return dp[n];
    }
}
