import java.lang.Math;
import java.lang.Character;

public class Solution {
    public int solve(String A) {
        int n = A.length();
        int max = 0;

        for(int i = 0; i < n; i++){
            char ch = Character.toLowerCase(A.charAt(i));
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                max = (max + (n-i)) % 10003;
            }
        }

        return max;
    }
}
