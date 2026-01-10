import java.util.*;

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        int n = A.size();
        for(int i = 0; i < n; i++){
            int cur = A.get(i);
            hashmap.put(cur, hashmap.getOrDefault(cur, 0) + 1);
        }
        for(int el: B){
            if(hashmap.containsKey(el)) ans.add(hashmap.get(el));
            else ans.add(0);
        }
        return ans;
    }
}
