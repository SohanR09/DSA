public class Solution {
    Map<Integer, String> charMap = new HashMap<>();
    public ArrayList<String> letterCombinations(String A) {
        charMap.put(0, "0");
        charMap.put(1, "1");
        charMap.put(2, "abc");
        charMap.put(3, "def");
        charMap.put(4, "ghi");
        charMap.put(5, "jkl");
        charMap.put(6, "mno");
        charMap.put(7, "pqrs");
        charMap.put(8, "tuv");
        charMap.put(9, "wxyz");

        ArrayList<String> result = new ArrayList<>();

        generateComibations(A, 0, new StringBuilder(), result);
        return result;
    }
    private void generateComibations(String input, int idx, StringBuilder ans, ArrayList<String> result){
        if(idx == input.length()){
            result.add(ans.toString());
            return;
        }
        int digit = (int)(input.charAt(idx) - '0');                 // get the number
        for(int i = 0; i < charMap.get(digit).length(); i++){
            ans.append(charMap.get(digit).charAt(i));               // get the alphabet from the map at each position
            generateComibations(input, idx + 1, ans, result);       // go to next character
            ans.setLength(ans.length() - 1);                        // delete the last character for back tracking
        }
    }
}
