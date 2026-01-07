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
import java.util.*;
public class Solution {
    int postOrdIdx = 0;
    
    public TreeNode buildTree(int[] A, int[] B) {
        Map<Integer, Integer> inOrder = new HashMap<>();
        for(int i = 0 ; i < B.length; i++){
            inOrder.put(A[i], i);
        }
        postOrdIdx = B.length - 1;
        return buildBinaryTree(inOrder, B, 0, A.length - 1);
    }
    private TreeNode buildBinaryTree(Map<Integer, Integer> inOrder, int[] postOrder, int inOrStart, int inOrEnd){
        if(postOrder.length != inOrder.size()){
            return null;
        }
        if(inOrStart > inOrEnd || postOrdIdx < 0){
            return null;
        }

        int rootVal = postOrder[postOrdIdx];
        postOrdIdx--;

        int rootIdx = inOrder.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        
        root.right = buildBinaryTree(inOrder, postOrder, rootIdx + 1, inOrEnd);
        root.left = buildBinaryTree(inOrder, postOrder, inOrStart, rootIdx - 1);
        
        return root;
    }
}
