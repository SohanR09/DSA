public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int max_sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int start = (i+1)*(j+1);
                int end = (n-i) * (m-j);
                int occ = start * end;
                max_sum += A.get(i).get(j) * occ;
            }
        }

        return max_sum;
    }
}
