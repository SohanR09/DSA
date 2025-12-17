public class Solution {
    public int[] maxone(int[] A, int B) {
        int n = A.length;

        int left = 0, right = 0;
        int countZero = 0, maxLength = 0, maxStart = 0;
        while(right < n){
            if(A[right] == 0) countZero++;
            while(countZero > B){
                if(A[left] == 0){
                    countZero--;
                }
                left++;
            }
            if(right - left > maxLength){
                maxLength = right - left;
                maxStart = left;
            }
            right++;
        }

        int[] ans = new int[maxLength + 1];
        for(int k = maxStart, l = 0; k <= maxStart + maxLength; k++, l++){
            ans[l] = k;
        }
        return ans;
    }
}
