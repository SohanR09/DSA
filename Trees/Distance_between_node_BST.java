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
    public int solve(TreeNode A, int B, int C) {
        return distBwtNodes(A, B, C, 0);
    }
    private int distBwtNodes(TreeNode root, int x, int y, int lvl){
        if(root == null){
            return 0;
        }

        if(root.val == x || root.val == y){
            return lvl;
        }
        int la = distBwtNodes(root.left, x, y, lvl + 1);
        int ra = distBwtNodes(root.right, x, y, lvl + 1);

        return la + ra;
    }
}
