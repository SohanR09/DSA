public class Solution {
    public int solve(char[] A) {
        int n = A.length;
        
        for(int i = 0; i < n; i++){
            if(!(A[i] >= 'A' && A[i] <= 'Z') 
                && !(A[i] >= 'a' && A[i] <= 'z') 
                && !(A[i] >= '0' && A[i] <= '9')) {
                return 0;
            }
        }

        return 1;
    }
}
