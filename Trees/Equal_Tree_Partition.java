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
    public int solve(TreeNode A) {
        return isEqualPartition(A) ? 1 : 0;
    }
    private boolean isEqualPartition(TreeNode root){
        if(root == null){
            return false;
        }
        long totalSum = sumTree(root);
        if(totalSum % 2 != 0){
            return false;
        }

        return handleTreePartition(root, totalSum);
    }
    private boolean handleTreePartition(TreeNode root, long totalSum){
        if(root == null){
            return false;
        }
        long leftSum = sumTree(root.left);
        long rightSum = sumTree(root.right);

        if((leftSum == totalSum / 2) || (rightSum == totalSum / 2)){
            return true;
        }

        boolean left = handleTreePartition(root.left, totalSum);
        boolean right = handleTreePartition(root.right, totalSum);
        
        return left || right;
    }
    private long sumTree(TreeNode root){
        if(root == null){
            return 0;
        }
        long leftSum = sumTree(root.left);
        long rightSum = sumTree(root.right);
        return root.val + leftSum + rightSum;
    }
}
