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
    public int lca(TreeNode A, int B, int C) {
        if(!findNode(A, B) || !findNode(A, C)){
            return -1;
        }
        return LCA(A, B, C);
    }
    private int LCA(TreeNode root, int B, int C) {
        if (root == null) {
            return -1;
        }

        if (root.val == B || root.val == C) {
            return root.val;
        }

        int left = LCA(root.left, B, C);
        int right = LCA(root.right, B, C);

        if (left != -1 && right != -1) {
            return root.val;
        }

        return (left != -1) ? left : right;
    }
    private boolean findNode(TreeNode root, int node){
        if(root == null){
            return false;
        }
        if(root.val == node){
            return true;
        }
        boolean la = findNode(root.left, node);
        boolean ra = findNode(root.right, node);

        return la || ra;
    }
}
