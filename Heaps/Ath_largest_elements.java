public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(A);

        int n = B.size();
        for (int i = 0; i < n; i++) {
            pq.offer(B.get(i));
            if (pq.size() > A) {
                pq.poll();
            }
            if (i < A - 1) {
                result.add(-1);
            } else {
                result.add(pq.peek());
            }
        }

        return result;        
    }
}
