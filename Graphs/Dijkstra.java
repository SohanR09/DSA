// TC: O(E + V)logV
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

    // global variables
    public boolean[] visited;
    public ArrayList<ArrayList<Pair>> adj;
    public PriorityQueue<Pair> pq;
    public int[] result;

    public int[] solve(int A, int[][] B, int C) {
        // initialise data structures
        visited = new boolean[A];
        adj = new ArrayList<ArrayList<Pair>>();
        pq = new PriorityQueue<Pair>((a, b) -> a.cost - b.cost);
        result = new int[A];

        // set result array values to max
        for (int i = 0; i < A; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        // generate a graph
        generateGraph(A, B);

        // add C to heap and update the result
        result[C] = 0;
        pq.add(new Pair(C, 0));

        // work till heap is not empty
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.cost;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            // visit neighbours
            for (Pair ngh: adj.get(node)) {
                int newCost = cost + ngh.cost;

                if (!visited[ngh.node] && newCost < result[ngh.node]) {
                    result[ngh.node] = newCost;
                    pq.add(new Pair(ngh.node, newCost));
                }
            }
        }

        for (int i = 0; i < A; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }

        return result;
    }

    public void generateGraph(int node, int[][] edges) {
        for (int i = 0; i < node; i++) {
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
