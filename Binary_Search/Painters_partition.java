import java.lang.*;
public class Solution {
    public int paint(int A, int B, int[] C) {
        int n = C.length;

        long s = findMax(C), e = totalSum(C);
        long ans = 0;
        
        while(s <= e){
            long mid = s + (e - s) / 2;

            if(isValid(C, A, mid)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return (int)(((ans % 10000003) * (B % 10000003)) % 10000003);
    }
    private boolean isValid(int[] A, int painter, long mid){
        int noOfPainters = 1;
        long sum = 0;
        for(int cur: A){
            sum += cur;
            if(sum > mid){
                sum = cur;
                noOfPainters++;
            }
        }
        if(noOfPainters > painter) return false;
        return true; 
    }
    private long findMax(int[] A){
        long max = Integer.MIN_VALUE;
        for(int cur: A){
            max = Math.max(max, cur);
        }
        return max;
    }
    private long totalSum(int[] A){
        long sum = 0;
        for(int cur: A){
            sum = (sum % 10000003 + cur % 10000003) % 10000003;
        }
        return sum;
    }
}
