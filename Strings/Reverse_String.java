public class Solution {
    public void reverse(String[] str){
        int start = 0;
        int end = str.length - 1;
        while(start < end){
            String temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
    public String solve(String A) {
        String[] str_array = A.trim().split(" ");
        int n = str_array.length;

        // reverse the string array
        reverse(str_array);

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < n; i++){
            if(i == 0) res.append(str_array[i]);
            else res.append(" "+ str_array[i]);
        }

        return res.toString();
    }
}
