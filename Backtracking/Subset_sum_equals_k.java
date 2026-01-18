public class Solution {
    public int SubsetSum(ArrayList<Integer> A, int B) {
        return FindSubSetSum(A, 0, B, 0);
    }
    private int FindSubSetSum(ArrayList<Integer> A, int idx, int target, int sum){
        if(sum == target){
            return 1;
        }
        if(idx == A.size()){
            return 0;
        }
        return Math.max(FindSubSetSum(A, idx+1, target, sum + A.get(idx)), FindSubSetSum(A, idx+1, target, sum));
    }
}
