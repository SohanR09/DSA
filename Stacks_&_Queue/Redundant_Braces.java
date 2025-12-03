import java.util.Stack;

public class Solution {
    public int braces(String A) {
        int n = A.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            char curr = A.charAt(i);

            if(curr == '(' || curr == '+' || curr == '-' || curr == '*' || curr == '/'){
                stack.push(curr);
            }else if(curr == ')'){
                char top = stack.peek();
                if(top == '+' || top == '-' || top == '*' || top == '/'){
                    stack.pop();
                    stack.pop();
                }else{
                    return 1;
                }
            }
        }

        return 0;
    }
}
