import java.lang.Math;
public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length, m = B.length;
        int i = 0, j = m-1;
        int dif = Math.abs(A[0] + B[m-1] - C);
        int newL = i, newR = j;

        while(i < n && j >= 0){
            int sum = A[i] + B[j];
            if(Math.abs(sum - C) < dif || 
                (Math.abs(sum - C) == dif && 
                (i < newL || (i == newL && j < newR)))){
                dif = Math.abs(sum - C);
                newL = i; newR = j;
            }
            if(sum > C){
                j--;
            }else if(sum < C){
                i++;
            }else{
                return new int[]{A[i], B[j]};
            }
        }

        return new int[]{A[newL], B[newR]};
    }
}
