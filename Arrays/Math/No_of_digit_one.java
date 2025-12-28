import java.lang.Math;
public class Solution {
    public int solve(int A) {
        int ans = 0;
        for(int i = 1; i <= A; i = i * 10){
            ans += ((A / (10 * i)) * i) + Math.min(Math.max(((A % (i * 10)) - (i - 1)) , 0), i);
        }
        return ans;
    }
}
