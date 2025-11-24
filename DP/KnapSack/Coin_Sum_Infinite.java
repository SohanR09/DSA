public class Solution {
    public int mod = 1000007;
    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int[] dp = new int[B+1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= B; j++) {
                if ( j - A[i] >= 0) {
                    dp[j] = (dp[j] + dp[j - A[i]]) % mod;
                }
            }
        }
        return dp[B];
    }
}
