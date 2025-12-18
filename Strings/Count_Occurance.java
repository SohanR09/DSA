// TC: O(n)
// SC: 
public class Solution {
    public int solve(String A) {
        int count = 0;
        char[] str = A.toCharArray();
        int n = str.length;

        for(int i = 0; i < n; i++){
            int first = i;
            int second = i + 1;
            int third = i+2;
            if((first >= 0 && third < n) && str[first] == 'b' && str[second] == 'o' && str[third] == 'b'){
                count++;
            }
        }

        return count;
    }
}
