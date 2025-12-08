public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        if ( A.size() < 1 ) return -1;

        int n = A.size(), m = A.get(0).size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                int cur = A.get(i).get(j);
                if (pq.size() < B) {
                    pq.offer(cur);
                } else if ( pq.peek() > cur ){
                    pq.poll();
                    pq.offer(cur);
                }
            }
        } 

        return pq.peek();
    }
}
