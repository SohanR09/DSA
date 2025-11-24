class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] robber = new int[n+1];
        robber[0] = 0;
        robber[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            robber[i] = Math.max( nums[i-1] + robber[i-2], robber[i-1]);
        }

        return robber[n];
    }
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] robber = new int[n + 1];
    //     Arrays.fill(robber, -1);

    //     money(n, robber, nums);

    //     return robber[n];
    // }
    // private int money(int n, int[] robber, int[] A) {
    //     if (n <= 0 ) return 0;
    //     if (robber[n] != -1) return robber[n];

    //     return robber[n] = Math.max(A[n-1] + money(n-2, robber, A), money(n-1, robber, A));
    // }
}