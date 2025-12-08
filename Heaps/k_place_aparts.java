public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        if ( A.size() < 1 ) return new ArrayList<>();
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for ( int i = 0; i <= B; i++ ) {
            pq.offer(A.get(i));
        }
        int idx = 0;
        for ( int i = B + 1; i < n; i++ ) {
            pq.offer(A.get(i));
            result.add(idx, pq.poll());
            idx++;
        }
        while ( !pq.isEmpty() ) {
            result.add(idx, pq.poll());
            idx++;
        }
        return result;
    }
}
