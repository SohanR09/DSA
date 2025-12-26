import java.lang.*;
public class Solution {
    private long helper(int A, int B){
        if(B == 0) return 1;
        long res = helper(A, B/2);
        if(B % 2 == 0){
            return res * res;
        }
        return res * res * A;
    }
    public Long power(int A, int B) {
        return helper(A, B);
    }
}
