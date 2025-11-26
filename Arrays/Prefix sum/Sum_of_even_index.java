public class Solution {
    static int[] prefixSumArray(int[] A){
        // create a prefix sum array
        // with same length of A
        int[] pf = new int[A.length];

        // initialise the prefix sum array
        // 1st element is stored
        // as it is
        pf[0] = A[0];

        // loop through the array
        for(int i = 1; i < A.length; i++){
            // check for even values
            if(i % 2 == 0){
                pf[i] = pf[i - 1] + A[i];
            }else{
                // elements which are not even
                pf[i] = pf[i - 1];
            }
        }

        return pf;
    }
    public int[] sumOfEvenIndexedElements(int[] A, int[][] B) {
        int n = A.length;       // array length
        int q = B.length;       // length of the 2D array

        // get the prefix sum array
        // of only even indices
        int[] pf = prefixSumArray(A);

        // sum array, with length based
        // on the length of the query 2d array
        int[] sum = new int[q];

        // single loop to traverse through the query array
        // and get the left and right indices
        for(int i = 0; i < q; i++){
            int l = B[i][0];    // left index
            int r = B[i][1];    // right index

            // check for left is zero
            if(l == 0){
                sum[i] = pf[r];
            }else{
                sum[i] = pf[r] - pf[l - 1];
            }
        }

        return sum;
    }
}
