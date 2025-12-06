import java.util.*;
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int mod = 1000000007;
        int idx = 0;

        int[] max = new int[n - B + 1];
        int[] min = new int[n - B + 1];

        Deque<Integer> dq_max = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!dq_max.isEmpty() && dq_max.peekFirst() <= i - B ){
                dq_max.poll();
            }
            while(!dq_max.isEmpty() && A.get(dq_max.peekLast()) < A.get(i)){
                dq_max.pollLast();
            }
            dq_max.addLast(i);
            if(i >= B - 1){
                max[idx] = A.get(dq_max.peekFirst());
                idx++;
            }
        }

        idx = 0;
        Deque<Integer> dq_min = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!dq_min.isEmpty() && dq_min.peekFirst() <= i - B ){
                dq_min.poll();
            }
            while(!dq_min.isEmpty() && A.get(dq_min.peekLast()) > A.get(i)){
                dq_min.pollLast();
            }
            dq_min.addLast(i);
            if(i >= B - 1){
                min[idx] = A.get(dq_min.peekFirst());
                idx++;
            }
        }

        int ans = 0;
        for(int i = 0; i < n - B + 1; i++){
            int sum = min[i] + max[i];
            ans = (ans + sum) % mod;
        }
        return (ans + mod) % mod;

    }
}
