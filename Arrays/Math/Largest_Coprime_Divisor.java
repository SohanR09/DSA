public class Solution {
    private int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    public int cpFact(int A, int B) {
        while(gcd(A, B) != 1){
            A = A / gcd(A, B);
        }
        return A;
    }
}
