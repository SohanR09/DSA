import java.util.*;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        long count = 0;
        final int mod = (int)(1e9 + 7);
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        int n = A.size();
        for(int i = 0; i < n; i++){
            int cur =  A.get(i);
            int x1 = cur - B;
            int x2 = cur + B;
            if(hashmap.containsKey(x1)){
                count += hashmap.get(x1);
            }
            if(hashmap.containsKey(x2)){
                count += hashmap.get(x2);
            }
            hashmap.put(cur, hashmap.getOrDefault(cur, 0) + 1);
        }
        return (int)(count % mod);
    }
}
