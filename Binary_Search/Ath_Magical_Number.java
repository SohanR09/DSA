import java.util.*;
import java.lang.*;
public class Solution {
    private int gcd(int A, int B){
        if(A == 0) return B;
        return gcd(B % A, A);
    }
    private long findCount(int B, int C, long mid){
        long lcm = (long)(B * C) / gcd(B, C);
        return (mid / B) + (mid / C) - (mid / lcm);
    }
    public int solve(int A, int B, int C) {
        long low = 1, high = (long)A * Math.min(B, C);
        long mod = 1000000007;

        while(low <= high){
            long mid = low + (high - low) / 2;
            long count = findCount(B, C, mid);
            if(count >= A) high = mid - 1;
            else low = mid + 1;
        }
        return (int)(low % mod);
    }
}
