import java.util.*;

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        for (int i = 0; i < B; i++) { 
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1); 
        } 
        ans.add(map.size());

        for (int i = B; i < n; i++) { 
            // Remove left element 
            map.put(A.get(i-B), map.get(A.get(i-B)) - 1); 
            if (map.get(A.get(i-B)) == 0) map.remove(A.get(i-B));

            // Add right element 
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);

            ans.add(map.size()); 
        }
        return ans;
    }
}
