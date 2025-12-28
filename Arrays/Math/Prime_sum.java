import java.util.*;
public class Solution {
    public ArrayList<Integer> primesum(int A) {
        boolean[] prime = new boolean[A+1];
        for(int i = 2; i <= A; i++){
            prime[i] = true;
        }
        for(int i = 2; i <= (A / i); i++){
            if(prime[i] == true){
                for(int j = i * i; j <= A; j += i){
                   prime[j] = false; 
                }
            }
        }
        ArrayList<Integer> primeNum = new ArrayList<>();
        for(int i = 2; i <= A; i++){
            if(prime[i] == true){
                primeNum.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= A/2; i++) {
            if (prime[i] && prime[A-i]) {
                ans.add(i);
                ans.add(A-i);
                break;  // We found the lexicographically smallest pair
            }
        }

        return ans;
    }
}
