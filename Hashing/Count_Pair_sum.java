import java.util.*;
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int mod = 1000000007;
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        int n = A.size();
        for(int i = 0; i < n; i++){
            int cur = A.get(i);
            int x = B - cur;
            if(hashmap.containsKey(x)){
                count += hashmap.get(x);
            }
            hashmap.put(cur, hashmap.getOrDefault(cur, 0) + 1);
        }

        return count % mod;
    }
}
