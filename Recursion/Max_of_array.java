import java.lang.*;

public class Solution {
    private int max(ArrayList<Integer> A, int idx){
        if(idx == A.size()) return A.get(A.size() -1);
        return Math.max(A.get(idx), max(A, idx +1));
    }
    public int getMax(ArrayList<Integer> A) {
        return max(A, 0);
    }
}
