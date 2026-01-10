// Do not write code to include libraries, main() function or accept any input from the console.
// Initialization code is already written and hidden from you. Do not write code for it again.
import java.util.*;
import java.lang.*;

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> count_A = new HashMap<>();
        HashMap<Integer, Integer> count_B = new HashMap<>();

        for(int el: A){
            count_A.put(el, count_A.getOrDefault(el, 0) + 1);
        }
        for(int el: B){
            count_B.put(el, count_B.getOrDefault(el, 0) + 1);
        }

// inbuild functions used to append n number of elements in the array list
        for(int key_A: count_A.keySet()){
            if(count_B.containsKey(key_A)){
                ans.addAll(Collections.nCopies(Math.min(count_A.get(key_A), count_B.get(key_A)), key_A));
            }
        }

        return ans;
    }
}
