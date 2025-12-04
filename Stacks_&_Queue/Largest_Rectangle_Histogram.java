import java.lang.Math;
import java.util.*;

public class Solution {
    private ArrayList<Integer> nextSmaller(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>(n);

         for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(n);
            }else{
                ans.add(stack.peek());
            }
            stack.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }
    private ArrayList<Integer> prevSmaller(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(stack.peek());
            }
            stack.push(i);
        }

        return ans;
    }
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();

        ArrayList<Integer> nsn = nextSmaller(A);
        ArrayList<Integer> psn = prevSmaller(A);

        long max = 0;

        for(int i = 0; i < n; i++){
            int width = nsn.get(i) - psn.get(i) - 1;

            long area = (long)A.get(i) * width;
            max = Math.max(max, area);

        }
        return (int)max % 1000000007;
    }
}
