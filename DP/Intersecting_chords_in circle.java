public class Solution {
    public int mod = 1000000007;

    public int chordCnt(int A) {
        if (A < 1) {
            return -1;
        }
        
        long[] dp = new long[A+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + dp[j] * dp[i - j - 1]) % mod;
            }
        }

        return (int)dp[A];
    }
}
