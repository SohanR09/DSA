public class Solution {
    private void countOcc(ArrayList<Integer> A, int idx, int target, ArrayList<Integer> res){
        if(idx == A.size()) return;
        if(A.get(idx) == target){
            res.add(idx);
        }
        countOcc(A, idx + 1, target, res);
    }
    public ArrayList<Integer> allIndices(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        countOcc(A, 0, B, res);
        return res;
    }
}
