import java.lang.Math;
public class Solution {
    int minDistance = Integer.MAX_VALUE;
    public int FindShortestPath(ArrayList<ArrayList<Integer>> A, int B, int C, int D, int E) {
        int n = A.size();
        int m = A.get(0).size();
        if(A.get(B).get(C) == 0 || A.get(D).get(E) == 0){
            return -1;
        }
        boolean[][] visited = new boolean[n][m];
        shortestPath(A, B, C, D, E, 0, visited);
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    private void shortestPath(ArrayList<ArrayList<Integer>> grid, int x, int y, int desX, int desY, int distance, boolean[][] visited){
        if(x == desX && y == desY){
            minDistance = Math.min(minDistance, distance);
            return;
        }
        visited[x][y] = true;
        int[] rowDir = new int[]{-1, 0, 1, 0};
        int[] colDir = new int[]{0, 1, 0, -1};

        for(int k = 0; k < 4; k++){
            int newX = x + rowDir[k];
            int newY = y + colDir[k];
            if((newX >= 0 && newX < grid.size()) && 
                (newY >= 0 && newY < grid.get(0).size()) && 
                grid.get(newX).get(newY) == 1 &&
                visited[newX][newY] == false){
                    shortestPath(grid, newX, newY, desX, desY, distance+1, visited);
                }
        }
        visited[x][y] = false;
    }
}
