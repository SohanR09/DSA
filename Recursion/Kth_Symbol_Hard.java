public class Solution {
    public int solve(int A, Long B) {
        return kthGrammar(A, B);
    }
    private int kthGrammar(int A, long B){
        if(A == 1){
            return 0;
        }
        if(B < Math.pow(2, A-2)){
            return kthGrammar(A-1, B);
        }else{
            return 1 - kthGrammar(A-1, B - (long)Math.pow(2, A-2));
        }
    }
}
