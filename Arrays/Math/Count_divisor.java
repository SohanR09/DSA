public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;
        
        int max = getMax(A);
        int[] div = new int[max+1];

        for(int i = 1; i <= max; i++){
            div[i] = 1;
        }
        for(int i = 1; i <= max / 2; i++){
            for(int j = 2 * i; j <= max; j = j + i){
                div[j] += 1;
            }
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = div[A[i]];
        }
        return ans;
    }
    private int getMax(int[] A){
        int max = Integer.MIN_VALUE;
        for(int cur: A){
            max = Math.max(max, cur);
        }
        return max;
    }
}
