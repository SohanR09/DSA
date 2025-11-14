// Problem Description

// There is a rectangle with left bottom as (0, 0) and right up as (x, y).

// There are N circles such that their centers are inside the rectangle.

// Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

// Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



// Problem Constraints

// 0 <= x , y, R <= 100

// 1 <= N <= 1000

// Center of each circle would lie within the grid



// Input Format

// 1st argument given is an Integer x , denoted by A in input.

// 2nd argument given is an Integer y, denoted by B in input.

// 3rd argument given is an Integer N, number of circles, denoted by C in input.

// 4th argument given is an Integer R, radius of each circle, denoted by D in input.

// 5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

// 6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



// Output Format

// Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



// Example Input

// Input 1:

//  x = 2
//  y = 3
//  N = 1
//  R = 1
//  A = [2]
//  B = [3]
// Input 2:

//  x = 3
//  y = 3
//  N = 1
//  R = 1
//  A = [0]
//  B = [3]


// Example Output
// Output 1:
//  NO
// Output 2:
//  YES

public class Solution {
    public class Dimension {
        int x;
        int y;
        public Dimension(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // matrix dimensions
    public int n;
    public int m;

    public boolean[][] visited;
    public int[][] matrix;
    public int[][] directions;
    public Queue<Dimension> q;

    public void initialiser(int A, int B) {
        n = A + 1;
        m = B + 1;

        directions = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        visited = new boolean[n][m];
        matrix = new int[n][m];

        q = new ArrayDeque<Dimension>();
    }

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        // All edge cases
        // when no circles are present answer is always gonna be yes
        if (C == 0) {
            return "YES";
        }
        // when only 1 circle, and its on the start
        // then we cannot start traversal
        if (C == 1 && E.get(0) == 0 && F.get(0) == 0) {
            return "NO";
        }
        // when we have a circle on the A a& B
        if (C == 1 && A == E.get(0) && B == F.get(0)) {
            return "NO";
        }

        // initialiser
        initialiser(A, B);

        // build the matrix for traversal
        buildMatrix(A, B, C, D, E, F);

        // bfs traversal
        return bfs(A, B, C, D, E, F);
    }

    public String bfs(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        q.add(new Dimension(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Dimension cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            if (A == x && B == y) {
                return "YES";
            }

            // look in all directions for 0s to traverse
            for (int[] dir: directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (isValidPath(nx, ny)) {
                    q.add(new Dimension(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return "NO";
    }

    public boolean isValidPath(int newX, int newY) {
        return newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && matrix[newX][newY] == 0;
    }
    
    public void buildMatrix(int x, int y, int numNodes, int radius, ArrayList<Integer> A, ArrayList<Integer> B) {
        // get all the circles
        for (int  i = 0; i < numNodes; i++) {
            int cirX = A.get(i);
            int cirY = B.get(i);

            matrix[cirX][cirY] = 1;

            // go to the circles neighbours
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dy = -radius; dy <= radius; dy++) {
                    int newX = cirX + dx;
                    int newY = cirY + dy;
                    if (isValidMatrixCell(newX, newY)) {
                        if (dx * dx + dy * dy <= radius * radius) {
                            matrix[newX][newY] = 1;
                        }
                    }
                }
            }
        }
    }
    public boolean isValidMatrixCell(int newX, int newY) {
        return newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == 0;
    }
}
