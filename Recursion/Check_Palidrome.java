public class Solution {
    private int palindrome(String A, int s, int e){
        if(s >= e) return 1;
        if(A.charAt(s) != A.charAt(e)) return 0;
        return palindrome(A, s+1, e-1);
    }
    public int solve(String A) {
        return palindrome(A, 0, A.length() - 1);
    }
}
