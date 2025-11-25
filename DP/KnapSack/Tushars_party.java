public class Solution {
    public int[] dp;

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A, final int[] B, final int[] C) {
        int n = B.length;

        int ans = 0;
        for (int friend: A) {
            // create friend dp array
            dp = new int[friend + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            
            // apply the unbounded approach for 0NKnapsack
            for (int i = 1; i <= friend; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - B[j] >= 0) {
                        dp[i] = Math.min(dp[i], C[j] + dp[i-B[j]]);
                    }
                }
            }
            // update the ans with the current friend cost
            ans += dp[friend];
        }
        
        return ans;
    }
}
