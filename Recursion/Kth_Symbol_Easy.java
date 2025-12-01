public class Solution {
    public int solve(int A, int B) {
        return getBthIndex(A, B);
    }
    private int getBthIndex(int A, int B){
        if(A == 1){
            return 0;
        }
        if(B < Math.pow(2, A-2)){
            return getBthIndex(A-1, B);
        }else{
            return 1 - getBthIndex(A-1, B - (int)Math.pow(2, A-2));
        }
    }
}
