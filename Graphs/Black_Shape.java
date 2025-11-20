public class Solution {
    public class Dimensions {
        int x;
        int y;

        public Dimensions(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int n;
    int m;

    public boolean[][] visisted;
    
    public int black(String[] A) {
        if (A.length < 1) {
            return 0;
        }

        int count = 0;

        n = A.length;
        m = A[0].length();

        visisted = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == 'X' && !visisted[i][j]) {
                    dfs(i, j, A);
                    count++;
                }
            }
        }
        
        return count;
    }

    public void dfs(int i, int j, String[] A) {
        visisted[i][j] = true;

        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};

        for (int k = 0; k < 4; k++) {
            int newX = i + row[k];
            int newY = j + col[k];

            if (isValidCell(newX, newY, A)) {
                dfs(newX, newY, A);
            }
        }
    }

    public boolean isValidCell(int newX, int newY, String[] A) {
        return newX >= 0 && newX < n && newY >= 0 && newY < m && A[newX].charAt(newY) == 'X' && !visisted[newX][newY];
    }
}
