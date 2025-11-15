public class Solution {
    public final int mod = 1000000007;

    public int solve(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int m = B.length;

        // Pointers from largest to smallest
        int i = n - 1;
        int j = m - 1;

        long rows = 1; // number of connected row-groups
        long cols = 1; // number of connected column-groups
        long cost = 0;

        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                cost = (cost + A[i] * cols) % mod;
                rows++;
                i--;
            } else {
                cost = (cost + B[j] * rows) % mod;
                cols++;
                j--;
            }
        }

        while (i >= 0) {
            cost = (cost + A[i] * cols) % mod;
            rows++;
            i--;
        }

        while (j >= 0) {
            cost = (cost + B[j] * rows) % mod;
            cols++;
            j--;
        }

        return (int)cost;
    }
}
