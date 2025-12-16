import java.lang.*;
public class Solution {
    public int maxArea(int[] A) {
        int n = A.length;
        if(n <= 1) return 0;
        
        int maxArea = -1;

        int i = 0, j = n-1;
        while(i < j){
            int area = Math.min(A[i], A[j]) * (j - i);
            maxArea = Math.max(maxArea, area);

            if(A[i] < A[j]){
                i++;
            }else if(A[i] > A[j]){
                j--;
            }else{
                i++; j--;
            }
        }
        return maxArea;
    }
}
