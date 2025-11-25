public class Solution {
    public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int maxLen = Integer.MIN_VALUE;

    public int solve(int[] A) {
        int n = A.length;
        // add to map
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        // i < j < k
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int len = maxFibLength(j, k, A);
                if (len >= 3) maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen < 3 ? 0 : maxLen;
    }

    public int maxFibLength(int j, int k, int[] A) {
        int target = A[k] - A[j];
        // check if target exists or not
        if (map.containsKey(target) && map.get(target) < j) {
            return 1 + maxFibLength(map.get(target), j, A);
        }

        return 2;
    }
}
