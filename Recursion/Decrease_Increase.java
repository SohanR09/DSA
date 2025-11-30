public class Solution {
    private void inc(int i){
        if(i == 1){
            System.out.print(1 + " ");
            return;
        }
        inc(i-1);
        System.out.print(i + " ");
    }
    private void dec(int n){
         if(n == 1){
            System.out.print(1 + " ");
            return;
        }
        System.out.print(n + " ");
        dec(n-1);
    }
    public void DecThenInc(int A) {
        dec(A);
        inc(A);
        System.out.println("");
    }
}
