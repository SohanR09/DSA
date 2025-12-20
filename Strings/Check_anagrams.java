public class Solution {
    public int solve(String A, String B) {
        char[] arr_A = A.trim().toCharArray();
        char[] arr_B = B.trim().toCharArray();

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0; i < arr_A.length; i++){
            char ch = arr_A[i];
            count1[ch - 'a']++;
        }

        for(int i = 0; i < arr_B.length; i++){
            char ch = arr_B[i];
            count2[ch - 'a']++;
        }

        for( int i = 0; i < count1.length; i++){
            if(count1[i] != count2[i]) return 0;
        }

        return 1;
    }
}
