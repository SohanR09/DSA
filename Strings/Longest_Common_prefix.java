import java.lang.Math;

public class Solution {
    public String longestCommonPrefix(String[] A) {
        int n = A.length;
        if(n == 0) return "";

        String res = "";

        
        int min  = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, A[i].length());
        }

        for(int i = 0; i < min; i++){
           char ch = A[0].charAt(i);
            for(int j = 1; j < n; j++) {
                if(A[j].charAt(i) != ch) {
                    return res;
                }
            }
            res += ch;
        }

        return res;
    }
}
