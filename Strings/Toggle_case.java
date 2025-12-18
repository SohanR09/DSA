
// TC: O(n)
// SC: O(1)
// can be solved using StringBuilder
public class Solution {
    public String solve(String A) {
        char[] charArray = A.toCharArray();
        int n = charArray.length;

        for(int i = 0; i < n; i++){
            char ch = charArray[i];
            if(charArray[i] >= 'A' && charArray[i] <= 'Z'){
                ch += 32;
                charArray[i] = ch;
            }else if(charArray[i] >= 'a' && charArray[i] <= 'z'){
                ch -= 32;
                charArray[i] = ch;
            }
        }

        String ans = new String(charArray);

        return ans;
    }
}
