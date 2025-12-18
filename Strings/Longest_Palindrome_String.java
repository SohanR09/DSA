// TC: O(N^2)
// SC: O(1)

import java.lang.Math;

public class Solution {
    public String longestPalindrome(String A) {
        int count = 1;
        int n = A.length();
        String ans = A.substring(0,1);

        // for odd length
        // check for the while loop condition
        // cehk the characters are same or not
        // if same then calculate the len
        // check if len > count and update the ans String
        // else break the loop

        for(int i = 0; i < n; i++){
            // these are all the indexs
            int mid = i;
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && right < n){
                if(A.charAt(left) == A.charAt(right)){
                    // get current length
                    int len = right - left + 1;

                    // update the answer 
                    if(len > count) ans = A.substring(left, right+1);

                    // update the max len of palindrome
                    count = Math.max(count, len);

                    // update the indexes
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }

        // for even length
        for(int i = 0; i < n; i++){
            // these are all the indexs
            int left = i;
            int right = i + 1;

            while(left >= 0 && right < n){
                if(A.charAt(left) == A.charAt(right)){
                    // get current length
                    int len = right - left + 1;

                    // update the answer 
                    if(len > count) ans = A.substring(left, right+1);

                    // update the max len of palindrome
                    count = Math.max(count, len);

                    // update the indexes
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }


        return ans;
    }
}
