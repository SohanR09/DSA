import java.util.*;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>(n - B + 1);
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.peekFirst() <= i - B){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && A.get(dq.peekLast()) < A.get(i)){
                dq.pollLast();
            }

            dq.addLast(i);

            if(i >= B- 1){
                result.add(A.get(dq.peekFirst()));
                idx++;   
            }
        }
        return result;
    }
}
