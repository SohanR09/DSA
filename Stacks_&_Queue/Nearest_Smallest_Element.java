import java.util.Stack;

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && A.get(i) <= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(i, -1);
            }else{
                ans.add(i, stack.peek());
            }
            stack.push(A.get(i));
        }

        return ans;
    }
}
