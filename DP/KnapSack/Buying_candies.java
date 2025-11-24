public class Solution {
    public int solve(int[] A, int[] B, int[] C, int D) {
        int n = A.length;
        // dp[j] = the maximum sweetness that can be obtained with a budget of j nibbles.
        int[] dp = new int[D + 1];

        // for (int i = 0; i < n; i++) {
        //     for (int j = C[i]; j <= D; j++) {
        //         // DP logic goes here
        //         dp[j] = Math.max(dp[j], dp[j - C[i]] + A[i] * B[i]);
        //     }
        // }

        for (int i = 1; i <= D; i++) {
            for (int j = 0; j < n; j++) {
                if (i - C[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - C[j]] + A[j] * B[j]);
                }
            }
        }
        return dp[D];
    }
}
