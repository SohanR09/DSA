public class Solution {
    private ArrayList<ArrayList<Integer>> tree;
    private int maxDistance;
    private int farthestNode;

    public int solve(int[] A) {
        int n = A.length;
        tree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // Build the undirected tree
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) {
                root = i;
            } else {
                tree.get(i).add(A[i]);
                tree.get(A[i]).add(i);
            }
        }

        // root to farthestNode
        maxDistance = -1;
        dfs(root, -1, 0);

        // farthestNode to maxDistance
        maxDistance = -1;
        dfs(farthestNode, -1, 0);

        return maxDistance;
    }

    public void dfs(int cur, int parent, int distance) {
        if (distance > maxDistance) {
            farthestNode = cur;
            maxDistance = Math.max(maxDistance, distance);
        }

        for (int ngh: tree.get(cur)) {
            if (ngh != parent) {
                dfs(ngh, cur, distance + 1);
            }
        }
    }
}
