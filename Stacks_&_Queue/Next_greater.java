import java.util.*;

public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        if(A.size() == 1) return new ArrayList<>(Arrays.asList(-1));;
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && A.get(i) >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(0, -1);
            }else{
                ans.add(0, stack.peek());
            }
            stack.push(A.get(i));
        }

        return ans;
    }
}
