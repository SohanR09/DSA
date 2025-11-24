public class Solution {
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int maxVal = 50 * n;
        int[] dp = new int[maxVal + 1];

        for (int i = 0; i < maxVal + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int val = maxVal; val >= 0; val--) {
                
                if (val - A[i] >= 0 && dp[val - A[i]] != Integer.MAX_VALUE)
                    dp[val] = Math.min(dp[val], B[i]  + dp[val - A[i]]);
            }
        }

        for (int val = maxVal; val >= 0; val--) {
            if (dp[val] <= C) {
                return val;
            }
        }
        return 0;
    }
}
