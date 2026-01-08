/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    private class Pair {
        int value;
        int height;

        Pair(int value, int height) {
            this.value = value;
            this.height = height;
        }
    }
    public ArrayList<Integer> solve(TreeNode A) {
        Map<Integer, Pair> map = new TreeMap<>();

        TVBT(A, 0, 0, map);

        ArrayList<Integer> result = new ArrayList<>();
        for (Pair p : map.values()) {
            result.add(p.value);
        }
        return result;
    }
    private void TVBT(TreeNode root, int vrtLvl, int height, Map<Integer, Pair> map){
        if(root == null){
            return;
        }

        if (!map.containsKey(vrtLvl) || height < map.get(vrtLvl).height) {
            map.put(vrtLvl, new Pair(root.val, height));
        }

        TVBT(root.left, vrtLvl - 1, height + 1, map);
        TVBT(root.right, vrtLvl + 1, height + 1, map);
    }
}
