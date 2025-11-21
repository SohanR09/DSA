public class Solution {
    public int solve(int[] A, int B, int C, int D) {
        if ( A.length <= 0 ) return -1;

        int n = A.length;
        
        int preMax1 = Integer.MIN_VALUE, 
            preMax2 = Integer.MIN_VALUE, 
            preMax3 = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            preMax1 = Math.max(preMax1, A[i] * B);
            preMax2 = Math.max(preMax2, A[i] * C + preMax1);
            preMax3 = Math.max(preMax3, A[i] * D + preMax2);
        }

        return preMax3;
    }
}
