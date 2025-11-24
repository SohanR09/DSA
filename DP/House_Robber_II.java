class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(getMax(nums, 0, n - 2), getMax(nums, 1, n - 1));
    }
    public int getMax(int[] A, int start, int end) {
       int len = end - start + 1;
        if (len == 1) return A[start];

        int[] dp = new int[len];
        
        // dp[0] corresponds to nums[start]
        dp[0] = A[start];
        // dp[1] corresponds to nums[start+1]
        dp[1] = Math.max(A[start], A[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(A[start + i] + dp[i-2], dp[i-1]);
        }


        return dp[len-1];
    }
}