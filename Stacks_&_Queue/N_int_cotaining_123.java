import java.util.*;
public class Solution {
    public ArrayList<Integer> solve(int A) {
        if(A == 1) return new ArrayList<>(Arrays.asList(1));
        if(A == 2) return new ArrayList<>(Arrays.asList(1, 2));
        if(A == 3) return new ArrayList<>(Arrays.asList(1, 2, 3));

        Deque<Integer> dq = new ArrayDeque<>(A);
        ArrayList<Integer> result = new ArrayList<>();

        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        int count = 3;

        while(count < A){
            int tempCount = 1;
            while(tempCount <= 3){
                int temp = dq.peekFirst();
                int num = temp * 10 + tempCount;
                dq.addLast(num);
                tempCount++;
            }
            int pop = dq.pollFirst();
            result.add(pop);
            count++;
        }
        while(!dq.isEmpty() && result.size() < A){
            result.add(dq.pollFirst());
        }
        return result;
    }
}
