public class Solution {
    public int solve(ArrayList<Integer> A) {
        long ans = 0;
        int mod = 1000000007;
        ArrayList<Integer> feq = new ArrayList<>();
        for(int i = 0; i <= 1000; i++){
            feq.add(0);
        }
        for(int el: A){
            feq.set(el, feq.get(el) +1);
        }
        for(int i = 1; i <= 1000; i++){
            for(int j = 1; j <= 1000; j++){
                int val = i % j;
                int temp = feq.get(i) * feq.get(j) * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }
        return (int) ans % mod;
    }
}
