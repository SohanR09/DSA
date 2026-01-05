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
        int res = checkRange(A, B, C);
        return res;
    }
    private int checkRange(TreeNode root, int min, int max){
        int count = 0;
        if(root == null){
            return 0;
        }
        if(root.val >= min && root.val <= max){
            count++;
        }
        count += checkRange(root.left, min, max);
        count += checkRange(root.right, min, max);
        return count;
    }
}
