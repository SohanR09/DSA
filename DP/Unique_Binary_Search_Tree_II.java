public class Solution {
    public int numTrees(int A) {
        int[] C = new int[A+1];
        C[0] = 1;
        C[1] = 1;

        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= i; j++) {
                C[i] += C[i-j] * C[j-1];
            }
        }
        return C[A];
    }
}
