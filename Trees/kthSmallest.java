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
    int idx = 0;
    public int kthsmallest(TreeNode A, int B) {
        return kthsmallestElement(A, B);
    }
    public int kthsmallestElement(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        // go eltreme left
        int left = kthsmallestElement(root.left, k);
        // check if we got the answer from left
        if (left != -1) return left;
        // update the node count
        idx++;
        // check for the node found
        if (idx == k) return root.val;

        // find in right node
        return kthsmallestElement(root.right, k);
    }
}
