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
    public int isValidBST(TreeNode A) {
        boolean res = checkValidBST(A, Integer.MIN_VALUE, Integer. MAX_VALUE);
        return res ? 1 : 0;
    }
    private boolean checkValidBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val < min || root.val > max){
            return false;
        }
        boolean left = checkValidBST(root.left, min, root.val - 1);
        boolean right = checkValidBST(root.right, root.val + 1, max);

        return left && right;
    }
}
