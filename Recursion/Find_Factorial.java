public class Solution {
    private int factorial(int n ){
        if(n == 0 || n == 1) return n;
        return factorial(n-1) * n;
    }
    public int solve(int A) {
       return factorial(A);  
    }
}
