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
    public int isSameTree(TreeNode A, TreeNode B) {
        return checkIsSame(A, B) ? 1 : 0;
    }
    private boolean checkIsSame(TreeNode x, TreeNode y){
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        if(x.val != y.val) return false;

        return checkIsSame(x.left, y.left) && checkIsSame(x.right, y.right);
    }
}
