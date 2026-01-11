import java.util.*;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Long, Integer> hashmap = new HashMap<>();
        int count = 0;

        long sum = 0;
        hashmap.put(sum, 1);

        for(int cur: A){
            sum += cur;
            long x = sum - B;
            count += hashmap.getOrDefault(x, 0);
            hashmap.put(sum, hashmap.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
