import java.util.Stack;

public class Solution {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int n = A.length();

        for(int i = 0; i < n; i++){
            char curr = A.charAt(i);

            if(curr == '{' || curr == '(' || curr == '['){
                stack.push(curr);
            }else{
                if(stack.isEmpty()){
                    return 0;
                }
                char top = stack.peek();
                if( (curr == '}' && top == '{') || 
                    (curr == ')' && top == '(') ||
                    (curr == ']' && top == '[') ){
                        stack.pop();
                }else return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
