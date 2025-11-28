public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        int maxLen = 0;
        long sum = 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(sum, -1);

        for (int i = 0; i < n; i++) {
            sum += A[i];

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
