public class Solution {
    public int solve(int[] A, int B) {
        if (A.length == 0 || B < 1) {
            return 0;
        }
        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // add all to the heap
        for (int cur: A) {
            pq.add(cur);
        }

        int eating = 0;

        // she will eat candies that are <= B
        while (!pq.isEmpty() && pq.peek() <= B) {
            int curCandie = pq.poll();
            // eating have the candies
            eating += curCandie / 2;

            int remCandies = curCandie - (curCandie / 2);

            // check queue is empty or not
            if (!pq.isEmpty()) {
                // get the next bag of candies and add the remaining to it
                pq.add(pq.poll() + remCandies);
            }
        }

        return eating;
    }
}
