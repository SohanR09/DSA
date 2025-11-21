public class Solution {
    public int maximalRectangle(int[][] A) {
        int n = A.length, m = A[0].length;

        int[][] dp = new int[n][m];

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;

                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        int height = i - k + 1;
                        maxArea = Math.max(maxArea, width * height);
                    }
                }
            }
        }
        return maxArea;
    }
}
