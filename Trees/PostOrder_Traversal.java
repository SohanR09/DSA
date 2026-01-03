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
    private void postOrdTrav(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        postOrdTrav(root.left, result);
        postOrdTrav(root.right, result);
        result.add(root.val);
    }
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrdTrav(A, result);
        return result;
    }
}
