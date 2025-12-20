public class Solution {
    static void reverse(char[] ch_array){
        int start = 0;
        int end = ch_array.length - 1;
        while(start < end){
            char temp = ch_array[start];
            ch_array[start] = ch_array[end];
            ch_array[end] = temp;
            start++;
            end--;
        }
    }
    public String solve(String A) {
        char[] ch_array = A.trim().toCharArray();
        int n = ch_array.length;

        reverse(ch_array);

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < n; i++){
            res.append(ch_array[i]);
        }

        return res.toString();
    }
}