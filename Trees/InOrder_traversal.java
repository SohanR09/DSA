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
    private void inorderTrav(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        inorderTrav(root.left, result);
        result.add(root.val);
        inorderTrav(root.right, result);
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderTrav(A, result);
        return result;
    }
}
