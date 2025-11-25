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
        if (!checkNode(A, B) || !checkNode(A, C)) {
            return -1;
        }

        return LCA(A, B, C);
    }
    public int LCA(TreeNode root, int x, int y) {
        if (root == null) {
            return -1;
        }
        if (root.val == x || root.val == y) {
            return root.val;
        }

        int la = LCA(root.left, x, y);
        int ra = LCA(root.right, x, y);

        if (la != -1 && ra != -1) {
            return root.val;
        }

        return la != -1 ? la : ra;
    }
    public boolean checkNode(TreeNode root, int x) {
        if (root == null) {
            return false;
        }
        if (root.val == x) {
            return true;
        }

        boolean la = checkNode(root.left, x);
        boolean ra = checkNode(root.right, x);

        return la || ra;
    }
}
