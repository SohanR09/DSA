public class Solution {
    public class Pair {
        int island;
        int cost;

        public Pair(int island, int cost) {
            this.island = island;
            this.cost = cost;
        }
    }

    public int minCost = 0;

    public boolean[] visitedIsland;
    public ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    public PriorityQueue<Pair> pq;

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // initiate the visitedIsland array
        visitedIsland = new boolean[A + 1];

        // create a undirected grapg of Pair class
        generateGraph(A, B);

        // sort the min heap based on the cost
        pq = new PriorityQueue<Pair>((a, b) -> a.cost - b.cost);

        // get the starting point of island
        // mark island 1 as visitedIsland
        addNeighbouringIslands(1);
        visitedIsland[1] = true;

        // calculate min cost till the min heap maintains all the islands
        while (!pq.isEmpty()) {
            Pair curIsland = pq.poll();

            if (!visitedIsland[curIsland.island]) {
                visitedIsland[curIsland.island] = true;
                minCost += curIsland.cost;

                addNeighbouringIslands(curIsland.island);
            }
        }

        return minCost;
    }

    public void generateGraph(int nodes, ArrayList<ArrayList<Integer>> edges) {
        for (int i = 0; i <= nodes; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (ArrayList<Integer> edge: edges) {
            int island1 = edge.get(0);
            int island2 = edge.get(1);
            int cost = edge.get(2);

            adj.get(island1).add(new Pair(island2, cost));
            adj.get(island2).add(new Pair(island1, cost));
        }
    }

    public void addNeighbouringIslands(int curIsland) {
        ArrayList<Pair> neighbouringIslands = adj.get(curIsland);

        for (Pair ngh :neighbouringIslands) {
            if (!visitedIsland[ngh.island]) {
                pq.offer(new Pair(ngh.island, ngh.cost));
            }
        }
    }
}
