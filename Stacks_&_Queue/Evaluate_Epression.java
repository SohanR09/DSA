import java.util.Stack;

public class Solution {
    public int evalRPN(ArrayList<String> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            String chara = A.get(i);
            if(!chara.equals("+") && !chara.equals("-") && !chara.equals("/") && !chara.equals("*")){
                stack.push(Integer.parseInt(chara));
            }else{
                if(stack.isEmpty()){
                   return -1; 
                }
                int el1 = stack.pop();
                if(stack.isEmpty()){
                    return -1;
                }
                int el2 = stack.pop();
                if(chara.equals("+")){
                    stack.push(el1 + el2);
                }else if(chara.equals("-")){
                    stack.push(el2 - el1);
                }else if(chara.equals("*")){
                    stack.push(el1 * el2);
                }else if(chara.equals("/")){
                    stack.push(el2 / el1);
                }else {
                    return -1;
                }
            }
        }

        if(stack.size() > 1){
            return -1;
        }
        return stack.peek();
    }
}
