public class Solution {
    private void dec(int n){
        if(n == 1){
            System.out.print(1 + " ");
            return;
        }
        System.out.print(n + " ");
        dec(n-1);
    }
    public void solve(int A) {
        dec(A);
        System.out.println("");
    }
}
