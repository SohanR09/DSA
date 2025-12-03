import java.util.Stack;
public class Solution {
    public String solve(String A) {
        int n = A.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            char cur = A.charAt(i);

            if(!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            char el = stack.pop();
            ans.append(el);
        }

        return ans.reverse().toString();
    }
}
