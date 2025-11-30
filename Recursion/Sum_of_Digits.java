public class Solution {
    private int digitSum(int n){
        if(n == 0) return 0;
        return digitSum(n/10) + n % 10;
    }
    public int solve(int A) {
        return digitSum(A);
    }
}
