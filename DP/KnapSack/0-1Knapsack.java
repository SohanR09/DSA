public class Solution {
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[] dp = new int[C+1];

        for (int i = 0; i < n; i++) {
            for (int wt = C; wt >= B[i]; wt--) {
                dp[wt] = Math.max(dp[wt], A[i] + dp[wt - B[i]]);
            }
        }

        return dp[C];
    }
}
