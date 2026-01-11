import java.util.*;

public class Solution {
    // Do not write code to include libraries, main() function or accept any input from the console.
    // Initialization code is already written and hidden from you. Do not write code for it again.
    public int solve(ArrayList<Integer> A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        Set<Long> hashset = new HashSet<>();
        long sum = 0;
        hashset.add(sum);  // This is the key change needed!

        for(int cur: A) {
            sum += cur;
            if(hashset.contains(sum)) return 1;
            hashset.add(sum);
        }
        return 0;
    }
}
