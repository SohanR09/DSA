public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int s = 0, e = n-1;

        while(s <= e){
            int midIdx  = s + (e-s) /2;
            int mid = A[midIdx];

            if((midIdx == 0 || mid >= A[midIdx-1]) && (midIdx == n-1 || mid >= A[midIdx+1])){
                return mid;
            }else if(midIdx > 0 && mid < A[midIdx-1]){
                e = midIdx -1;
            }else if(midIdx < n-1 && mid < A[midIdx+1]){
                s = midIdx +1;
            }
        }

        return 0;
    }
}
