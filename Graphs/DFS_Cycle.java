// Directed Graph Cycle
// TC: O(E + V)
// SC: O(E + V)
public class Solution {
    public int isCycleFound = 0;
    public boolean[] visited;
    public boolean[] path;
    public ArrayList<ArrayList<Integer>> adj;

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // create a directed graph
        adj = directedGraph(A, B);
        // visited array of A nodes
        visited = new boolean[A + 1];
        // path array
        path = new boolean[A + 1];

        // we may have to consider 
        // the multiple components also
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        return isCycleFound;
    }

    public void dfs(int cur) {
        // base case
        visited[cur] = true;
        path[cur] = true;

        // get the neighbour
        for (int ngh: adj.get(cur)) {
            // keep check for the path is visited
            if (path[ngh]) {
                isCycleFound = 1;
                return;
            }
            if (!visited[ngh]) {
                dfs(ngh);
            }
        }

        // clear the path
        path[cur] = false;
    }

    public ArrayList<ArrayList<Integer>> directedGraph(int nodes, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (ArrayList<Integer> edge: edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
        }

        return adjList;
    }
}

// undirected Graph traversal
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = createGraph(V, edges);
        
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean check = dfs(i, -1, visited, adj);
                if (check) return true;
            }
        }
        return false;
    }
    private boolean dfs(int cur, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[cur] = true;
        
        for (int ngh: adj.get(cur)) {
            // if not visisted of ngh
            if (!visited[ngh]) {
                boolean check = dfs(ngh, cur, visited, adj);
                if(check) return true;
            }
            // visited raha toh
            else if (ngh != parent) {
                return true;
            }
        }
        
        return false;
    }
    private ArrayList<ArrayList<Integer>> createGraph(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int[] e: edges) {
            int start = e[0];
            int end = e[1];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        
        return adj;
    }
}
