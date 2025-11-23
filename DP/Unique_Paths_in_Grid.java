public class Solution {
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length, m = A[0].length;

        if (A[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[n][m];
        // 1st row
        for (int j = 0; j < m; j++) {
            if (A[0][j] == 0) dp[0][j] = 1;
            else break;
        }
        // 1st column
        for (int i = 0; i < n; i++) {
            if (A[i][0] == 0) dp[i][0] = 1;
            else break;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n-1][m-1];
    }
}
