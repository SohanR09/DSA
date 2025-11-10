// TC: O(E + V)
// Sc: O(E + V)
class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
                
        for (int i = 0; i < adj.size(); i++) {
            // current not visited
            if (!visited[i]) {
                dfs(i, adj, visited, ans);
            }
        }
        
        return ans;
    }
    
    private void dfs(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[cur] = true;    // 0 vis, 2 vis, 4 vis, 3 vis, 1 vis
        ans.add(cur);       // 0 2 4 3 1
        
        // bhai tera neighboorsd kon kon hain
        for (int neighboor: adj.get(cur)) { // 0 -> 2, 3, 1  || 2-> 0, 4 || 4 -> 2
            if (!visited[neighboor]) {
                dfs(neighboor, adj, visited, ans);
            }
        }
    }
}
// 0 -> 2, 3, 1
// 1 -> 0
// 2 -> 0, 4
// 3 -> 0
// 4 -> 2
// 5 -> 6
// 6 -> 5
// 7 -> 

