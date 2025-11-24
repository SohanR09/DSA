public class Solution {
    public int[] dp;

    public int solve(int A, int[] B, int[] C) {
        int n = B.length;
        int[] dp = new int[A+1];

        for (int j = 1; j <= A; j++) {
            for (int i = 0; i < n; i++) {
                if (j >= C[i]) {
                    dp[j] = Math.max(dp[j], B[i] + dp[j - C[i]]);
                }
            }
        }
        return dp[A];

        // dp = new int[A+1];
        // Arrays.fill(dp, -1);
        // return unBoundedKnapSack(n-1, A, B, C);
    }
    private int unBoundedKnapSack(int i, int wt, int[] values, int[] weights) {
        if (i < 0 || wt == 0) {
            return 0;
        }

        if (dp[wt] != -1) {
            return dp[wt];
        }

        int inc = 0;
        if (weights[i] <= wt) {
            inc = values[i] + unBoundedKnapSack(i, wt - weights[i], values, weights);
        }

        int exc = unBoundedKnapSack(i-1, wt, values, weights);

        return dp[wt] = Math.max(inc, exc);
    }
}
