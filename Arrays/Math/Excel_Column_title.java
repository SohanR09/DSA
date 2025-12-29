public class Solution {
    public String convertToTitle(int A) {
        StringBuilder ans = new StringBuilder();

        while(A > 0){
            int rem = A % 26;
            ans.append( (char)('A' + rem) );
            A = A / 26;
        }

        return ans.reverse().toString();
    }
}
