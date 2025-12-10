// Do not write code to include libraries, main() function or accept any input from the console.
// Initialization code is already written and hidden from you. Do not write code for it again.
import java.lang.*;

public class Solution {
    private long helper(int A, int B, int C){
        if(B == 0) return 1;
        long res = helper(A, B/2, C);
        if(B % 2 == 0){
            return (res * res) % C;
        }
        return (((res * res) % C) * (A % C)) % C;
    }
    public int pow(int A, int B, int C) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        long res = helper(A, B, C);
        if(res < 0) return ((int) res + C) % C;
        return (int) res % C; 
    }
}
