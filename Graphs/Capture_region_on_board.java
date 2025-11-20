public class Solution {
    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int n, m;
    public Queue<Pair> q = new ArrayDeque<Pair>();

	public void solve(ArrayList<ArrayList<Character>> a) {
        if (a == null || a.isEmpty()) return;

        n = a.size();
        m = a.get(0).size();

        // turn all border Os to Ns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n-1 || j == 0 || j == m-1) && a.get(i).get(j) == 'O') {
                    a.get(i).set(j, 'N');
                    q.add(new Pair(i, j));
                }
            }
        }

        // work till we have all the border Ns
        while (!q.isEmpty()) {
            Pair curCell = q.poll();
            int x = curCell.x;
            int y = curCell.y;

            int[] rows = new int[]{0, 1, 0, -1};
            int[] cols = new int[]{-1, 0, 1, 0};

            for (int i = 0; i <= 3; i++) {
                int newX = x + rows[i];
                int newY = y + cols[i];

                if (isValidCell(newX, newY, a)) {
                    a.get(newX).set(newY, 'N');
                    q.add(new Pair(newX, newY));
                }
            }
        }

        // convert all the remaining Os to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a.get(i).get(j) == 'O') {
                    a.get(i).set(j, 'X');
                }
            }
        }

        // finally turn all Ns to Os
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a.get(i).get(j) == 'N') {
                    a.get(i).set(j, 'O');
                }
            }
        }
	}

    public boolean isValidCell(int x, int y, ArrayList<ArrayList<Character>> A) {
        return x >= 0 && x < n && y >= 0 && y < m && A.get(x).get(y) == 'O';
    }
}
