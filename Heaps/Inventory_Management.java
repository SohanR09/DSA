public class Solution {
    public class Pair {
        int time;
        int profit;

        public Pair(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }
    int mod = 1000000007;

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> timePro = new ArrayList<>();
        int n = A.size();
        for (int i = 0 ; i < n; i++) {
            timePro.add(new Pair(A.get(i), B.get(i)));
        }
        timePro.sort((a, b) -> a.time - b.time);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int t = 0;
        for (int i = 0; i < n; i++) {
            if (t < timePro.get(i).time) {
                pq.offer(timePro.get(i).profit);
                t++;
            } else if (timePro.get(i).profit > pq.peek()) {
                pq.poll();
                pq.offer(timePro.get(i).profit);
            }
        }

        int totalProfit = 0;
        while (!pq.isEmpty()) {
            totalProfit = (totalProfit + pq.poll()) % mod;
        }
        return totalProfit;
    }
}
