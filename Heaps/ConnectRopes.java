// TC: O(n)
// SC: O(n)
public class Solution {
    public int solve(int[] A) {
        if (A.length <= 0) {
            return 0;
        }
        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int cur: A) {
            pq.add(cur);
        }

        int minCost = 0;

        while (!pq.isEmpty() && pq.size() != 1) {
            int el1 = pq.poll();
            int el2 = pq.poll();
            minCost += el1 + el2;
            pq.add(el1 + el2);
        }

        return minCost;
    }
}
