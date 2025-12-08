public class Solution {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int el: A){
            pq.offer(el);
            sum += el;
        }
            
        while(B > 0){
            int cur = pq.poll();
            cur = cur * -1;
            sum += 2 * cur;
            pq.offer(cur);
            
            B--;
        }

        return (int)sum;
    }
}
