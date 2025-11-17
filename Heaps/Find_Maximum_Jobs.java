public class Solution {
    public class Time{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() < 1 || B.size() < 1) {
            return 0;
        }
        PriorityQueue<Time> pq = new PriorityQueue<Time>((a, b) -> a.end - b.end);
        for (int i = 0; i < A.size(); i++) {
            pq.add(new Time(A.get(i), B.get(i)));
        }

        int jobs = 0;
        int lastJobEnded = 0;

        while (!pq.isEmpty()) {
            Time cur = pq.poll();
            int start = cur.start;
            int end = cur.end;

            if (start >= lastJobEnded) {
                jobs++;
                lastJobEnded = end;
            }
        }

        return jobs;
    }
}
