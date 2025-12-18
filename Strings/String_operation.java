public class Solution {
    static String deleteUpperCase(String str){
        int n = str.length();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if((ch >= 'a') && (ch <= 'z')){
                res.append(ch);
            }
        }

        return res.toString();
    }

    static String replaceVowels(String str){
        int n = str.length();
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                res.append('#');
            }else{
                res.append(ch);
            }
        }

        return res.toString();
    }

    public String solve(String A) {
        String str = "";

        // Delete the uppercase
        str = deleteUpperCase(A);

        // replace the vowels with #
        str = replaceVowels(str);

        // Concatenate with the string itself
        str = str + str;

        return str;
    }
}
