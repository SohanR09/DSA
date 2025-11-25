public class Solution {
    public ArrayList<String> PrintAllPaths(int A, int B) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        followPath(0, 0, A, B, ans, result);

        return result;
    }

    public void followPath(int i, int j, int x, int y, StringBuilder ans, ArrayList<String> result) {
        if (i == x-1 && j == y-1) {
            result.add(ans.toString());
            return;
        }

        if (i < x-1) {
            ans.append("D");
            followPath(i + 1, j, x, y, ans, result);
            ans.setLength(ans.length() - 1);
        }

        if (j < y-1) {
            ans.append("R");
            followPath(i, j+1, x, y, ans, result);
            ans.setLength(ans.length() - 1);
        }
    }
}
