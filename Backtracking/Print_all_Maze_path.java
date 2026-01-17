public class Solution {
    public ArrayList<String> PrintAllPaths(int A, int B) {
        ArrayList<String> result = new ArrayList<>();
        pathWay(0, 0, A, B, new StringBuilder(), result);
        return result;
    }
    private void pathWay(int n, int m, int A, int B, StringBuilder ans, ArrayList<String> result){
        if(n == A-1 && m == B-1){
            result.add(ans.toString());
            return;
        }
        if(n == A || m == B){
            return;
        }
        pathWay(n+1, m, A, B, ans.append("D"), result);
        ans.setLength(ans.length() - 1);
        
        pathWay(n, m+1, A, B, ans.append("R"), result);
        ans.setLength(ans.length() - 1);
    }
}
