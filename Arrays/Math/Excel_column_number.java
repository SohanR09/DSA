import java.lang.*;
public class Solution {
    public int titleToNumber(String A) {
        int n = A.length();
        int result = 0;

        for(int i = 0; i < n; i++){
            result = result * 26 + (A.charAt(i) - 'A' + 1);
        }

        return result;
    }
}
