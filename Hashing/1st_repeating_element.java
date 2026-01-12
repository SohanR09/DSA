import java.util.*;

public class Solution {
    public int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for(int cur: A){
            hashmap.put(cur, hashmap.getOrDefault(cur, 0) + 1);
        }

        for(int cur: A){
            if(hashmap.get(cur) > 1) return cur;
        }

        return -1;
    }
}
