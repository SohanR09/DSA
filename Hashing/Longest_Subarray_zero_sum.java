import java.util.*;

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();

        Map<Long, Integer> hashmap = new HashMap<>();
        int maxLen = 0;
        long sum = 0;
        hashmap.put(sum, -1);

        for(int i = 0; i < n; i++){
            long cur = A.get(i);
            sum += cur;
            if(sum == 0 || hashmap.containsKey(sum)) {
                int len = i - hashmap.get(sum);
                if(len > maxLen) maxLen = len;
            }else { 
                hashmap.put(sum, i); 
            }
        }
        return maxLen;
    }
}
