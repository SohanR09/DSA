import java.util.*;
public class Solution {
    private String flatten(String str){
        int n = str.length();
        Map<Character, Integer> varMap = new HashMap<>();
        char curSign = '+';
        Stack<Character> stack = new Stack<>();
        stack.push('+');
        // positive: 1
        // negative: -1

        int i = 0;
        while(i < n){
            char curr = str.charAt(i);

            if(curr == '-' || curr == '+'){
                curSign = curr;
                i++;
            }else if(curr == '('){
                char top = stack.peek();
                char effsign = combinedSign(curSign, top);
                stack.push(effsign);
                curSign = '+';
                i++;
            }else if(curr == ')'){
                stack.pop();
                i++;
            }else if(Character.isLetter(curr)){
                char top = stack.peek();
                char effsign = combinedSign(curSign, top);
                varMap.put(curr, effsign == '-' ? -1 : 1);
                i++;
            }else i++;
        }

        StringBuilder res = new StringBuilder();
        // as HashMap has no sequense iterate using alphabets
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(varMap.containsKey(ch)) res.append(ch).append(":").append(varMap.get(ch)).append(",");
        }
        return res.toString();
    }
    private char combinedSign(char a, char b){
        if(a == b) return '+';
        return '-';
    }
    public int solve(String A, String B) {
        String a = flatten(A);
        String b = flatten(B);
        
        return a.equals(b) ? 1 : 0;
    }
}
