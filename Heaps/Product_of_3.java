public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));

        if (n < 3) return result;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(A.get(i));
            if (pq.size() > 3) {
                pq.poll();
            }

            if (i >= 2) {
                long product = 1;
                for (int num : pq) {
                    product *= num;
                }
                result.set(i, (int)product);
            }
        }

        return result;
    }
}
