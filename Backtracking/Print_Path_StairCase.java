public class Solution {
    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        climb(A, new ArrayList<Integer>(), result);
        return result;
    }
    private void climb(int A, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> result){
        if(A == 0){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(A >= 1){
            ans.add(1);
            climb(A-1, ans, result);
            ans.remove(ans.size() - 1);
            
            ans.add(2);
            climb(A-2, ans, result);
            ans.remove(ans.size() - 1);
        }
    }
}
