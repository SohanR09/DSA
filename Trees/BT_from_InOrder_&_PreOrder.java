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
    int preOrIdx = 0;
    public TreeNode buildTree(int[] A, int[] B) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            inOrderMap.put(B[i], i);
        }

        return build(A, inOrderMap, 0, B.length - 1);
    }
    private TreeNode build(int[] preOrder, Map<Integer, Integer> inOrderMap, int ins, int ine){
        if(preOrder.length != inOrderMap.size()){
            return null;
        }
        if(ins > ine || preOrIdx >= preOrder.length){
            return null;
        }

        int rootVal = preOrder[preOrIdx];
        preOrIdx++;
        int rootIdx = inOrderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preOrder, inOrderMap, ins, rootIdx - 1);
        root.right = build(preOrder, inOrderMap, rootIdx + 1, ine);

        return root;
    }
}
