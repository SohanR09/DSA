public class Solution {
    public int[] indegree;
    public ArrayList<ArrayList<Integer>> adj;
    public Queue<Integer> q;
    public int[] result;

    public int solve(int A, int[] B, int[] C) {
        // initialise data structures
        indegree = new int[A + 1];
        adj = new ArrayList<ArrayList<Integer>>();
        q = new ArrayDeque<Integer>();
        result = new int[A];

        // generate a graph to connect all courses
        generateGraph(A, B, C);

        // generate a indegree array for all the nodes
        generateIndegreeArray(A);

        // check for the source using indegree
        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // check for the queue is empty or not
        while (!q.isEmpty()) {
            int cur = q.poll();
            // get the node
            // result[i] = cur;
            // i++;

            for (int ngh: adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0) {
                    q.add(ngh);
                }
            }
        }


        return isValid() ? 1 : 0;
    }

    public void generateGraph(int nodes, int[] B, int[] C) {
        for (int i = 0; i <= nodes; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i];
            int v = C[i];

            adj.get(u).add(v);
        }
    }

    public void generateIndegreeArray(int nodes) {
        for (int i = 1; i <= nodes; i++) {
            for (int ngh: adj.get(i)) {
                indegree[ngh]++;
            }
        }
    }

    public boolean isValid() {
        for (int el: indegree) {
            if (el != 0) return false;
        }
        return true;
    }
}
