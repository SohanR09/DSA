public class Solution {
    public int solve(int A) {
        if ( A < 1 )
            return 0;

        int coins = 0;

        int cur = 1;
        while (cur * 5 <= A) { cur *= 5; }

        while (cur >= 1) { 
            coins += A / cur; 
            A %= cur; 
            cur /= 5; 
        }

        return coins;
        
    }
}
