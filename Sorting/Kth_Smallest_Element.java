
import java.util.Arrays;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);

        for(int i = 0; i < n; i++){
            if( i == B - 1) return A[i];
        }

        return 0;
    }
}
