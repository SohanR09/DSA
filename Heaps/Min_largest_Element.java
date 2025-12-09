public class Solution {
    private class Pair{
        int cur;
        int idx;

        Pair(int cur, int idx){
            this.cur = cur;
            this.idx = idx;
        }
    }
    
    public int solve(int[] A, int B) {
        int n = A.length;

        // state array to track the updated state
        int[] state = new int[n];

        // min heap, & sorting based on the cur value
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cur - b.cur);

        int i = 0;
        for(int el: A){
            pq.offer(new Pair(2 * el, i));
            state[i] = el;
            i++;
        }

        while(B-- > 0){
            // get the min value from the heap
            Pair top = pq.poll();
            int val = top.cur;
            int idx = top.idx;

            // update the state array
            state[idx] = val;

            // update the min heap
            pq.offer(new Pair(val + A[idx], top.idx)); 
        }

        // get the max from the state array
        int maxVal = Integer.MIN_VALUE;
        for(int el: state){
            maxVal = Math.max(maxVal, el);
        }

        return maxVal;
    }
}