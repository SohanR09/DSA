import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();

        int[] dp = new int[A+1];
        dp[1] = 1;
        for(int i = 2; i < A + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.print(dp[A]);
    }
}