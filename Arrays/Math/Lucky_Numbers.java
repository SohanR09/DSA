import java.util.*;
public class Solution {
    public int solve(int A) {
        boolean[] isPrime = getPrime(A);
        int[] sieve = new int[A+1];

        for(int i = 2; i <= A; i++){
            for(int j = 2 * i; j <= A; j = j + i){
                if(isPrime[i] == true){
                    sieve[j] += 1;
                }
            }
        }
        
        int count = 0;
        for(int i = 1; i <= A; i++){
            if(sieve[i] == 2){
                count++;
            }
        }
        return count;
    }
    private boolean[] getPrime(int A){
        boolean[] isPrime = new boolean[A+1];
        for(int i = 1; i <= A; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i <= A / i; i++){
            if(isPrime[i] == true){
                for(int j = i * i; j <= A; j += i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
