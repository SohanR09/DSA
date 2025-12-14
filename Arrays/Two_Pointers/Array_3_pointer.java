import java.lang.*;
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int minAns = Integer.MAX_VALUE;
        int n = A.length, m = B.length, l = C.length;
        int i = 0, j = 0, k = 0;

        while(i < n && j < m && k < l){
            int maxOne = Math.max( Math.abs(A[i] - B[j]), Math.abs(B[j] - C[k]) );
            int maxFinal = Math.max(maxOne, Math.abs(C[k] - A[i]));

            minAns = Math.min(minAns, maxFinal);
            
            if (A[i] <= B[j] && A[i] <= C[k]) {
                i++;
            } else if (B[j] <= A[i] && B[j] <= C[k]) {
                j++;
            } else {
                k++;
            }
        }

        return minAns;
    }
}
