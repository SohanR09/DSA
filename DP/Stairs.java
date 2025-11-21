public class Solution {
    int MOD = 1000000007;
    public int climbStairs(int A) {
        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        return dp[A] % MOD;
    }
    private int climbing(int n, int[] dp) {
        if (n == 0 || n == 1 ) {
            return 1;
        }
        if ( dp[n] != -1 ) {
            return dp[n];
        }

        return dp[n] = climbing(n-1, dp) + climbing(n-2, dp);
    }
}
