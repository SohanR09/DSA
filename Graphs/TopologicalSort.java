// TC: O(E)logV 
// SC: O(E + V)
public class Solution {
    public int[] indegree;
    public ArrayList<ArrayList<Integer>> adj;
    public PriorityQueue<Integer> pq;
    public int[] result;

    public int[] solve(int A, int[][] B) {
        // initialise the data structures
        indegree = new int[A + 1];
        adj = new ArrayList<ArrayList<Integer>>();
        pq = new PriorityQueue<Integer>();
        result = new int[A];

        // generate a directed graph
        generateGraph(A, B);

        // generate indegree array
        generateIndegreeArray(A);

        // add all the source to Queue
        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        int i = 0;
        // work till q is not empty
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            result[i] = curr;
            i++;
            for (int ngh: adj.get(curr)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0) {
                    pq.add(ngh);
                }
            }
        }

        return isValid(A) ? result : new int[0];
    }

    public void generateGraph(int nodes, int[][] edges) {
        for (int i = 0; i <= nodes; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
    }

    public void generateIndegreeArray(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            for (int ngh: adj.get(i)) {
                indegree[ngh]++;
            }
        }
    }

    public boolean isValid(int A) {
        for (int i = 1; i <= A; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
