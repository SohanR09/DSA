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
    public int hasPathSum(TreeNode A, int B) {
        return hasEqualPathSum(A, B) ? 1 : 0;
    }
    private boolean hasEqualPathSum(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(root.val == target){
                return true;
            }
            return false;
        }
        boolean left = hasEqualPathSum(root.left, target - root.val);
        boolean right = hasEqualPathSum(root.right, target - root.val);
        
        return left || right;
    }
}
