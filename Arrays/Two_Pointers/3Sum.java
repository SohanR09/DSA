public class Solution {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;

        // edge case
        if (n < 3) return 0;

        // initial sum
        int closestSum = A[0] + A[1] + A[2];
        
        // work through the array till n-2
        for (int i = 0; i < n - 2; i++) {
            // assign two pointers
            int j = i + 1, k = n-1;

            while (j < k) {
                // get cur sum
                int curSum = A[i] + A[j] + A[k];

                // update the closest sum
                if (Math.abs(B - curSum) < Math.abs(B - closestSum)) {
                    closestSum = curSum;
                }

                // move two pointers
                if (curSum < B) {
                    j++;
                } else if (curSum > B) {
                    k--;
                } else if (curSum == B) {
                    return curSum;
                }
            }
        }

        return closestSum;
    }
}
