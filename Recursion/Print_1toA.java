public class Solution {
    private void inc(int A){
        if(A == 1) {
            System.out.print(1 + " ");
            return;
        }
        inc(A-1);
        System.out.print(A + " ");
    }
    public void solve(int A) {
        inc(A);
        System.out.println("");
    }
}
