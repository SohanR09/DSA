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
    int maxDiameter = Integer.MIN_VALUE;
    public int solve(TreeNode A) {
        diameter(A);
        return maxDiameter;
    }
    public int diameter(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int la = diameter(root.left);
        int ra = diameter(root.right);

        maxDiameter = Math.max(la + ra + 2, maxDiameter);

        return Math.max(ra, la) + 1;
    }
}
