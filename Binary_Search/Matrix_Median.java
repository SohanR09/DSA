import java.util.*;
import java.lang.Math;
public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            low = Math.min(low, A.get(i).get(0));
            high = Math.max(high, A.get(i).get(m-1));
        }

        int reqMid = (n * m) / 2;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int smallEqual = countSmallEquals(A, n, m, mid);
            if(smallEqual <= reqMid){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int countSmallEquals(ArrayList<ArrayList<Integer>> A, int n, int m, int mid){
        int count = 0;

        for(int i = 0; i < n; i++){
            count += upperBound(A.get(i), mid, m);
        }

        return count;
    }

    private int upperBound(ArrayList<Integer> row, int mid, int length){
        int low = 0, high = length - 1;
        int ans = length;

        while(low <= high){
            int midVal = low + (high - low) / 2;
            if(row.get(midVal) > mid){
                ans = midVal;
                high = midVal - 1;
            }else {
                low = midVal + 1;
            }
        }
        return ans;
    }
}
