import java.util.Stack;

public class Solution {
    public int solve(int A, int B, ArrayList<Integer> C) {
        if(A == 0) return B;
        if(A == 1 && C.size() == 1) return C.get(0);

        int n = C.size();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(C.get(i) != 0){
                stack.push(C.get(i));
            }else{
                stack.pop();
            }
        }

        if(stack.isEmpty()) return B;
        return stack.peek();
    }
}
