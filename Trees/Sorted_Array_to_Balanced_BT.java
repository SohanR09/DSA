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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final List<Integer> A) {
        TreeNode root = sortedBST(A, 0, A.size() - 1);
        return root;
    }
    private TreeNode sortedBST(List<Integer> A, int s, int e){
        if(s > e) return null;
        
        int mid = s + (e - s) / 2;

        TreeNode root = new TreeNode(A.get(mid));
        
        root.left = sortedBST(A, s, mid - 1);
        root.right = sortedBST(A, mid + 1, e);

        return root;
    }
}
