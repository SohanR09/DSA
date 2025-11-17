public class Solution {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null)
            return 0;
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int el: A) {
            pq1.add(el);
        }
        for (int el: B) {
            pq2.add(el);
        }

        int maxVal = Integer.MIN_VALUE, n = A.size();

        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            int val1 = pq1.isEmpty() ? 0 : pq1.poll();
            int val2 = pq2.isEmpty() ? 0 : pq2.poll();

            maxVal = Math.max(maxVal, Math.abs(val1 - val2));
        }

        
        return maxVal;
    }
}
