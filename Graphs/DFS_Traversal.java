// UnDirected Graph

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


// Directed Graph Trversal from node 1 to A
public class Solution {
    public int[] visited;
    ArrayList<ArrayList<Integer>> adj;
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // create a graph
        adj = createDirectedGraph(A, B);

        visited = new int[A + 1];

        dfs(1);

        return visited[A];
    }
    public void dfs(int cur) {
        visited[cur] = 1;

        // adj.get(idx) give the ArrayList if neighbour
        // on which we are applying the loop
        for (int neigh: adj.get(cur)) {
            if (visited[neigh] == 0) {
                dfs(neigh);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> createDirectedGraph(int A, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (ArrayList<Integer> curEdge: edges) {
            adj.get(curEdge.get(0)).add(curEdge.get(1));
        }

        return adj;
    } 
}

