public class Solution {
    public int adjacent(int[][] A) {
        int n = A.length, m = A[0].length;

        if (m < 1) {
            return 0;
        }
        // edge case
        if (m == 1) {
            return Math.max( A[0][0], A[1][0] );
        }

        // max of each column with ROW 2
        int[] dp = new int[m];
        dp[m-1] = Math.max( A[0][m-1], A[1][m-1] );
        dp[m-2] = Math.max( Math.max( A[0][m-2], A[1][m-2] ), dp[m-1] );

        for (int k = m-3; k >= 0; k--) {
            dp[k] = Math.max( Math.max( A[0][k], A[1][k] ) + dp[k+2], dp[k+1] );
        }

        return dp[0];
    }
}
