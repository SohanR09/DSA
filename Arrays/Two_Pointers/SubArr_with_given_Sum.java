import java.util.*;
// for(int cur: A){
//     sum += cur;
//     long x = sum - B;
//     count += hashmap.getOrDefault(x, 0);
//     hashmap.put(sum, hashmap.getOrDefault(sum, 0) + 1);
// }
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();

        Map<Long, Integer> hashmap = new HashMap<>();
        long sum = 0;
        hashmap.put(sum, -1);
        ArrayList<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = 0;
        while(right < n){
            int cur  = A.get(right);
            sum += cur;
            while(sum > B && left <= right){
                sum -= A.get(left);
                left++;
            }
            if(sum == B){
                for(int i = left; i <= right; i++){
                    ans.add(A.get(i));
                }
                break;
            }
            right++;
        }

        if(ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }
}
