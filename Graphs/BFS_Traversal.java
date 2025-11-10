// TC: O(E + V)
// SC: O(E)
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<Integer>();
        ArrayList<Integer> neigh = adj.get(0);
        visited[0] = true;
        for (int ngh: neigh) {
            q.add(ngh);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (!visited[cur]) {
                visited[cur] = true;
                result.add(cur);
                ArrayList<Integer> neighbour = adj.get(cur);
                for (int ngh: neighbour) {
                    if (!visited[ngh]) {
                        q.add(ngh);
                    }
                }
            }
        }
        
        return result;
    }
}