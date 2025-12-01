public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[A.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        generatePermute(A, 0, visited, ans, result);
        return result;
    }
    private void generatePermute(ArrayList<Integer> A, int idx, boolean[] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> result){
        if(idx == A.size()){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0; i < A.size(); i++){
            if(visited[i] == false){
                visited[i] = true;
                ans.add(A.get(i));
                generatePermute(A, idx + 1, visited, ans, result);
                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
        }
    }
}
