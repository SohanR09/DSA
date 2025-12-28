import java.lang.Math;
public class Solution {
    public int solve(int A) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(2*A); i++){
            int T = A - ((i * (i - 1)) / 2);
            if(T % i == 0) count++;
        }
        return count;
    }
}
