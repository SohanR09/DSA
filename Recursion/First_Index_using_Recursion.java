public class Solution {
    private int found(ArrayList<Integer> A, int B, int idx){
        if(idx == A.size()) return -1;
        if(A.get(idx) == B) return idx;
        return found(A, B, idx + 1);
    }
    public int FirstIndex(ArrayList<Integer> A, int B) {
        return found(A, B, 0);
    }
}
