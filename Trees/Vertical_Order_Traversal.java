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
    Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        
        // tree node, column index, row index, map
        VOT(A, 0, 0);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(Map<Integer, List<Integer>> vertOrderMap : map.values()){
            ArrayList<Integer> column = new ArrayList<>();
            for (List<Integer> levelList : vertOrderMap.values()) {
                column.addAll(levelList);
            }
            result.add(column);
        }
        
        return result;
    }
    
    private void VOT(TreeNode root, int lvl, int rowLvl){
        if(root == null){
            return;
        }

        map.putIfAbsent(lvl, new TreeMap<>());
        map.get(lvl).putIfAbsent(rowLvl, new ArrayList<>());
        map.get(lvl).get(rowLvl).add(root.val);

        VOT(root.left, lvl - 1, rowLvl + 1);
        VOT(root.right, lvl + 1, rowLvl + 1);
    }
}
