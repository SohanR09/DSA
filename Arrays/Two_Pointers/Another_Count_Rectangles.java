public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int mod = 1000000007;

        int i = 0, j = n-1;
        long count = 0;

        while(i < n && j >= 0){
            long product = (long) A[i] * A[j];
            if(product < B){
                // if (i == j) {
                //     count = (count + 1) % mod;
                // } else {
                //     count = (count + 2 * (j - i) + 1) % mod;
                // }
                
                // j+1 for 0 indexing
                count = ( count + j + 1 ) % mod;
                i++;
            }else{
                j--;
            }
        }

        return (int)count;
    }
}
