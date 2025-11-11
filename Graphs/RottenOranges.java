// TC: O(E + V)
// SC: O(E + V)
public class Solution {
    public class Pair {
        int x;
        int y;
        int min;

        public Pair(int x, int y, int min) {
            this.x = x;
            this.y = y;
            this.min = min;
        }
    }

    public int freshOranges = 0;
    public int minutes = 0;
    public int n, m;
    public Queue<Pair> q = new ArrayDeque<Pair>();

    public int solve(ArrayList<ArrayList<Integer>> A) {
        n = A.size();
        m = A.get(0).size();

        // get the fresh & rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    freshOranges++;
                } else if (A.get(i).get(j) == 2) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        // check for fresh oranges & rotten oranges
        if (freshOranges == 0) {
            return 0;
        }
        if (q.isEmpty() && freshOranges > 0) {
            return -1;
        }

        // work through the queue and calculate minutes
        while (!q.isEmpty()) {
            // get the current Pair
            Pair cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            minutes = cur.min;

            int[] rows = new int[]{0, -1, 0, 1};
            int[] cols = new int[]{-1, 0, 1, 0};
            // check for fresh oranges & make them rotten
            for (int i = 0; i <= 3; i++) {
                int newX = x + rows[i];
                int newY = y + cols[i];
                
                // boundry checks & check for 1 in cell
                if (isValidCell(newX, newY, A)) {
                    A.get(newX).set(newY, 2);
                    freshOranges--;
                    q.add(new Pair(newX, newY, minutes + 1));
                }
            }
        }

        return freshOranges > 0 ? -1 : minutes;
    }

    public boolean isValidCell(int x, int y, ArrayList<ArrayList<Integer>> A) {
        return x >= 0 && x < n && y >= 0 && y < m && A.get(x).get(y) == 1;
    }
}
