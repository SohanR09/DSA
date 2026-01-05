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
    public TreeNode solve(TreeNode A, int B) {
        TreeNode root = deleteNode(A, B);
        return root;
    }
    private TreeNode deleteNode(TreeNode root, int target){
        if(root == null){
            return null;
        }
        if(root.val == target){
            // leaf node
            if(root.left == null && root.right == null){
            return null;
            }
            
            // single node
            if(root.left == null || root.right == null){
                if(root.left == null){
                    return root.right;
                }
                if(root.right == null){
                    return root.left;
                }
            }

            // two nodes
            swapNodesAndDelete(root);
            return root;           
        }

        if(root.val > target){
            root.left = deleteNode(root.left, target);
        }
        else root.right = deleteNode(root.right, target);

        return root;
    }
    private void swapNodesAndDelete(TreeNode root){
        // two nodes
        TreeNode temp = root.left;
        TreeNode largest = findLargestNode(temp);

        root.val = largest.val;  // Replace the value

        root.left = deleteNode(root.left, largest.val);  // Delete the largest node from left subtree
    }
    private TreeNode findLargestNode(TreeNode root){
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }
}
