import java.util.*;

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int mod = 1000000007;
        Map<Long, Integer> hashmap = new HashMap<>();
        long sum = 0;
        hashmap.put(sum, 1);
        long count = 0;

        for(int cur: A){
            sum += cur;
            count += hashmap.getOrDefault(sum, 0);
            hashmap.put(sum, hashmap.getOrDefault(sum, 0) + 1);
        }
        return (int)(count % mod);
    }
}
