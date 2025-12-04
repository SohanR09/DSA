public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        if(A.size() == 1) return new ArrayList<>(Arrays.asList(-1));;
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && A.get(i) >= A.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(0, n);
            }else{
                ans.add(0, stack.peek());
            }
            stack.push(i);
        }

        return ans;
    }
    public ArrayList<Integer> prevGreater(ArrayList<Integer> A) {
        if(A.size() == 1) return new ArrayList<>(Arrays.asList(-1));;
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && A.get(i) >= A.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(i, -1);
            }else{
                ans.add(i, stack.peek());
            }
            stack.push(i);
        }

        return ans;
    }
    public ArrayList<Integer> nextSmaller(ArrayList<Integer> A) {
        if(A.size() == 1) return new ArrayList<>(Arrays.asList(-1));;
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(0, n);
            }else{
                ans.add(0, stack.peek());
            }
            stack.push(i);
        }

        return ans;
    }
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(i, -1);
            }else{
                ans.add(i, stack.peek());
            }
            stack.push(i);
        }

        return ans;
    }
    public int solve(ArrayList<Integer> A) {
        int n = A.size();

        int mod = 1000000007;
        long ans = 0;

        ArrayList<Integer> nsn = nextSmaller(A);
        ArrayList<Integer> psn = prevSmaller(A);
        ArrayList<Integer> ngn = nextGreater(A);
        ArrayList<Integer> pgn = prevGreater(A);

        for(int i = 0; i < n; i++){
            long max = (long)(ngn.get(i) - i) * (i - pgn.get(i));
            long min = (long)(nsn.get(i) - i) * (i - psn.get(i));

            ans = (ans + (long)A.get(i) * (max - min)) % mod;
        }

        return (int)(ans + mod) % mod;
    }
}
