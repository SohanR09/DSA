public class Solution {
    int mod = 1000000007;

    public int solve(int A, int B) {
        int[][] dp = new int[A+1][B+1];

        for (int d = 1; d <= 9; d++) {
            if (d <= B) {
                dp[1][d] = 1;
            }
        }

        for (int i = 2; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int d = 0; d <= 9; d++) {
                    if (j >= d) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-d]) % mod;
                    }
                }
            }
        }
        return dp[A][B];
    }
}
