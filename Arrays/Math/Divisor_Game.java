public class Solution {
    private int gcd(int a, int b){
        if( a == 0 ) return b;
        return gcd(b % a, a);
    }
    public int solve(int A, int B, int C) {
        int count = 0;
        int lcm = (B * C) / gcd(B, C);
        count = A / lcm;
        return count;
    }
}
