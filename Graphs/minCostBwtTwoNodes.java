// TC: O(ElogV)
// SC: O(E + V)
public class Solution {
    public class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public boolean[] visited;
    public ArrayList<ArrayList<Pair>> adj;
    public PriorityQueue<Pair> pq;
    public int[] result;

    public void initialiseDS(int nodes) {
        visited = new boolean[nodes];

        adj = new ArrayList<ArrayList<Pair>>();

        pq = new PriorityQueue<Pair>((a, b) -> a.cost - b.cost);

        result = new int[nodes];
        Arrays.fill(result, Integer.MAX_VALUE);
    }
    
    public int solve(int A, int[][] B, int C, int D) {
        // initialise
        initialiseDS(A);

        // generate a undirected graph
        generateGraph(A, B);

        // get the source
        result[C] = 0;
        pq.offer(new Pair(C, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.cost;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            for (Pair ngh: adj.get(node)) {
                int newCost = cost + ngh.cost;

                if (!visited[ngh.node] && newCost < result[ngh.node]) {
                    result[ngh.node] = newCost;
                    pq.offer(new Pair(ngh.node, newCost));
                }
            }
        }

        // use the result array to get the min destination cost
        return result[D] == Integer.MAX_VALUE ? -1 : result[D];
    }

    public void generateGraph(int nodes, int[][] edges) {
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, cost));
        }
    }
}
