public class Solution {
    private int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    public int solve(int A, int B) {
        if(A > B) return A - B;
        if(A < B) return B - A;
        return A;
    }
}
