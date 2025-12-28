import java.lang.*;
public class Solution {
    public int solve(int A, int B, int C) {
        int[][] Com = new int[A+1][B+1];

        for(int i = 0; i <= A; i++){
            for(int j = 0; j <= Math.min(i, B); j++){
                if(j == 0 || j == i){
                    Com[i][j] = 1;
                }else{
                    Com[i][j] = (Com[i-1][j-1] + Com[i-1][j]) % C;
                }
            }
        }

        return Com[A][B] % C;
    }
    // recusion is an optional solution but not an optimal approach for bigger numbers
    private int combination(int n, int r, int m){
        if(n == r){
            return 1;
        }
        if(r == 1){
            return n;
        }
        return (combination(n-1, r-1, m) % m + combination(n-1, r, m) % m) % m;
    }
}
