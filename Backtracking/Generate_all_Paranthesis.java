public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        generateStrings(A, A, new StringBuilder(), result);
        return result;
    }
    private void generateStrings(int opened, int closed, StringBuilder ans, ArrayList<String> result){
        if(opened == 0 && closed == 0){
            result.add(ans.toString());
            return;
        }
        if(opened > 0){
            generateStrings(opened - 1, closed, ans.append("("), result);
            ans.setLength(ans.length() - 1);
        }
        if(opened < closed){
            generateStrings(opened, closed - 1, ans.append(")"), result);
            ans.setLength(ans.length() - 1);
        }
    }
}
