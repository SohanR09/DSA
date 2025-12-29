public class Solution {
    public int findRank(String A) {
        int n = A.length();
        long rank = 1;

        for(int i = 0; i < n; i++){
            int smallerCount = 0;
            for(int j = i+1; j < n; j++){
                if(A.charAt(j) < A.charAt(i)){
                    smallerCount++;
                }
            }
            long contribution = (smallerCount * factorial(n-i-1)) % 1000003;
            rank = (rank + contribution) % 1000003;
        }

        return (int)rank;
    }
    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res * i) % 1000003;
        }
        return res;
    }
}
