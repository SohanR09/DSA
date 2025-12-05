import java.util.*;
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> ans = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        int n = A.size();
        for(int i = n-1; i >= 0; i--){
            int curr = A.get(i);
            while(!ans.isEmpty() && curr < ans.peek()){
                int top = ans.pop();
                temp.push(top);
            }
            ans.push(curr);  
            while(!temp.isEmpty()){
                int top = temp.pop();
                ans.push(top);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!ans.isEmpty()){
            result.add(ans.pop());
        }
        Collections.reverse(result);
        return result;
    }
}
