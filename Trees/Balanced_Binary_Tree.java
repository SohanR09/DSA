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
import java.lang.Math;
public class Solution {
    boolean isBinTree = true;

    public int isBalanced(TreeNode A) {
        height(A);
        return isBinTree ? 1 : 0;
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right); 
        if(Math.abs(leftHeight - rightHeight) > 1){
            isBinTree = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
