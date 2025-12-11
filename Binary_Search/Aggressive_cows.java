import java.lang.Math;
import java.util.*;

public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        
        int n = A.length;
        int s = minDistanceBetConStall(A), e = getMaxMinusMin(A);
        int ans = 0;

        while(s <= e){
            int mid = s + (e - s) / 2;

            if(isValid(A, B, mid)){
                ans = mid;
                s = mid + 1;
            }else e = mid -1;
        }

        return ans;
    }
    private boolean isValid(int[] A, int cow, int mid){
        int noOfCows = 1;
        int last = 0;
        for(int i = 0; i < A.length; i++){
            int dis = A[i] - A[last];
            if(dis >= mid){
                last = i;
                noOfCows++;
            }
        }
        if(noOfCows < cow) return false;
        return true;
    }
    private int getMaxMinusMin(int[] A){
        int min = Integer.MAX_VALUE;
        for(int cur: A){
            min = Math.min(min, cur);
        }
        int max = Integer.MIN_VALUE;
        for(int cur: A){
            max = Math.max(max, cur);
        }
        return max - min;
    }
    private int minDistanceBetConStall(int[] A){
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++){
            min = Math.min(min, Math.abs(A[i] - A[i-1]));
        }
        return min;
    }
}
