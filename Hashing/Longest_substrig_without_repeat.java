import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        int n = A.length();

        int maxLen = 0;
        Set<Character> hashset = new HashSet<Character>();

        int left = 0;
        int right = 0;
        while(right < n){
            char ch = A.charAt(right);
            if(!hashset.contains(ch)){
                hashset.add(ch);
                int len = right - left + 1;
                if(len > maxLen) maxLen = len;
                right++;
            }else{
                hashset.remove(A.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}
