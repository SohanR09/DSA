public class Solution {
    public int solve(int A, int B) {
        int ans = 0;
        // both works
        // for(int i = 0; i < 32; i++){
        //     if( i == A || i == B) ans = ans | (1 << i);
        // }
        ans = ans | (1 << A);
        ans = ans | (1 << B);
        return ans;
    }
}
