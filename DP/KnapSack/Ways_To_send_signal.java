public class Solution {
    public int mod = 1000000007;

    public int solve(int A) {
        long[][] dp = new long[A + 1][2];

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j < 2; j++) {
                // check for base case
                if (i == 0 || i == 1) {
                    dp[i][j] = 1;
                } else {
                    // start from i = 2
                    // we have the off state
                    if ( j == 0 ) {
                        dp[i][j] = (dp[i-1][0] + dp[i-1][1]) % mod;
                    } 
                    // we have the on state
                    else {
                        dp[i][j] = dp[i-1][0];
                    }
                }
            }
        }

        return (int)(dp[A][0] + dp[A][1]) % mod;
    }
}
