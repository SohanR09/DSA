import java.util.Collections;
import java.lang.Math;

public class Solution {
    private int getMaxofArr(ArrayList<Integer> A){
        int max = Integer.MIN_VALUE;
        for(int cur: A){
            max = Math.max(max, cur);
        }
        return max;
    }
    private int getTotalSum(ArrayList<Integer> A){
        int sum = 0;
        for(int cur: A){
            sum += cur;
        }
        return sum;
    }
    private boolean isAvaliable(ArrayList<Integer> A, int mid, int B){
        int student = 1;
        int pages = 0;
        for(int cur: A){
            if(pages + cur > mid){
                pages = 0;
                student++;
            }
            pages += cur;
        }
        // if(student < B) return false;
        return student <= B;
    }
    public int books(ArrayList<Integer> A, int B) {

        int s = getMaxofArr(A);
        int e = getTotalSum(A);

        int ans = -1;

        while(s <= e){
            int mid = s + (e - s) / 2;
            if(isAvaliable(A, mid, B)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        if(A.size() < B) return -1;
        return ans;
    }
}
