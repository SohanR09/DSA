public class Solution {
    private int found(ArrayList<Integer> A, int B, int idx){
        if(idx == -1) return -1;
        if(A.get(idx) == B) return idx;
        return found(A, B, idx - 1);
    }
    public int LastIndex(ArrayList<Integer> A, int B) {
        return found(A, B, A.size()-1);
    }
}
