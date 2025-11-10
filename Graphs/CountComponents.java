class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        
        int count = 0;
        
        for (int i = 0; i < adj.size(); i++) {
            // current not visited
            if (!visited[i]) {
                dfs(i, adj, visited, ans);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[cur] = true;
        ans.add(cur);
        
        for (int neighboor: adj.get(cur)) {
            if (!visited[neighboor]) {
                dfs(neighboor, adj, visited, ans);
            }
        }
    }
}