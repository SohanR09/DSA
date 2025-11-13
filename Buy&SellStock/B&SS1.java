// TC: O(n)
// SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int n = prices.length;
        int maxProfit = 0;
        int minStock = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minStock = Math.min(minStock, prices[i]);
            if (prices[i] > minStock) {
                maxProfit = Math.max(maxProfit, prices[i] - minStock);
            }
        }

        return maxProfit;
    }
}