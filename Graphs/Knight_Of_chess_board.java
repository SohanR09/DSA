public class Solution {
    public class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // dimensions
    public int n, m;

    public int[][] board;
    public boolean[][] visited;
    
    public int[][] moves = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

    public Queue<Pair> q = new ArrayDeque<Pair>();


    public int knight(int A, int B, int C, int D, int E, int F) {
        // A x B size
        // C & D source 
        // E & F destination

        // edge case
        if (C > A || D > B || E > A || F > B) {
            return -1;
        }

        // barod dimensions
        n = A;
        m = B;

        // build the board with 1s
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], 1);
        }

        // visisted array
        visited = new boolean[n][m];

        // add the source to the Queue
        q.add(new Pair(C-1, D-1));
        // the starting point is always 0;
        board[C-1][D-1] = 0;

        while (!q.isEmpty()) {
            // get the current cell
            Pair curCell = q.poll();
            int x = curCell.x;
            int y = curCell.y;

            // check for destination
            if (x == E - 1 && y == F -1) {
                return board[x][y];
            }

            // check for visisted
            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            // move the knight in all 8 directions
            for (int k = 0; k < 8; k++) {
                int newX = x + moves[k][0];
                int newY = y + moves[k][1];

                // check for a valid move
                if (isValidMove(newX, newY)) {
                    // update the knight shortest path using the previous value
                    board[newX][newY] = board[x][y] + 1;

                    // add the new dimensions to the Queue
                    q.add(new Pair(newX, newY));
                }
            }
        }

        // no shortest path found
        return -1;
    }
    
    public boolean isValidMove(int newX, int newY) {
        return newX >= 0 && newX < n && newY >= 0 && newY < m && board[newX][newY] == 1 && !visited[newX][newY];
    }
}
