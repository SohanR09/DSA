public class Solution {
    private int sumDigit(int A){
        if(A == 0) return 0;
        return sumDigit(A / 10) + A % 10;
    }
    public int solve(int A) {
        int res = sumDigit(A);
        while(res > 9){
            res = sumDigit(res);
        }
        return res == 1 ? 1 : 0;
    }
}
