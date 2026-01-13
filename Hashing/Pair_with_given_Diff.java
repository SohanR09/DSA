import java.util.*;
public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);

        int n = A.length;
        int i = 0, j = i + 1;
        int count = 0;

       while (i < n && j < n) {
            if (i == j || A[j] - A[i] < B) {
                j++;
            } else if (A[j] - A[i] > B) {
                i++;
            } else {
                // We found a pair
                int x = A[i], y = A[j];
                while(i < n && A[i] == x){
                    i++;
                }
                while(j < n && A[j] == y){
                    j++;
                }

                // Add to count
                count++;
            }
        }
        return count;
    }
}
