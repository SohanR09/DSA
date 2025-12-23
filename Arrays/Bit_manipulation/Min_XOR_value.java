import java.lang.*;
import java.util.*;

public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans  = A.get(0) ^ A.get(1);
        int n = A.size();
        for(int i = 1; i < n; i++){
            ans = Math.min( A.get(i) ^ A.get(i-1), ans);
        }
        return ans;
    }
}
