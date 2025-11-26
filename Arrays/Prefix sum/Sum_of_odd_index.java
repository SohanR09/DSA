public class Solution {
    static int[] prefixSumArrayOfOdd(int[] A){
        int n = A.length;           // Array length
        int[] pf = new int[n];       // create prefix sum array

        // initial value of prefix array
        pf[0] = 0;
        
        // loop to get the array elements
        for(int i = 1; i < n; i++){
            // check for odd indices
            // and for even it would be the 
            // same sum as previous index
            if(i % 2 != 0){
                pf[i] = pf[i-1] + A[i];
            }else{
                pf[i] = pf[i-1];
            }
        }

        return pf;
    }

    static int[] getSum(int[] A, int[][] B){
        int q = B.length;           // length of the 2D array
        int[] sum = new int[q];     // create a sum array of length = B array

        // get the prefix sum array
        int[] pf = prefixSumArrayOfOdd(A);

        // loop through the query array
        // get the left and right elements
        // and calculate the sum
        for(int i = 0; i < q; i++){
            int l = B[i][0];
            int r = B[i][1];

            if(l == 0){
                sum[i] = pf[r];
            }else{
                sum[i] = pf[r] - pf[l-1];
            }
        }

        return sum;
    }

    public int[] sumOfOddIndexedElements(int[] A, int[][] B) {
        int[] result = getSum(A, B);

        return result;
    }
}
