import java.util.*;
public class Solution {
    public String solve(String A) {
        Deque<Character> dq_var = new ArrayDeque<>();
        Map<Character, Integer> map_var = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        int n = A.length();
        for(int i = 0; i < n; i++){
            char curr = A.charAt(i);

            map_var.put(curr, map_var.getOrDefault(curr, 0) + 1);
            dq_var.addLast(curr);

            while(!dq_var.isEmpty() && (map_var.get(dq_var.peekFirst()) > 1)){
                dq_var.pollFirst();
            }
            if(!dq_var.isEmpty()){
                ans.append(dq_var.peekFirst());
            }else{
                ans.append('#');
            }
        }
        return ans.toString();
    }
}
