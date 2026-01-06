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
    public int t2Sum(TreeNode A, int B) {
        Set<Integer> set = new HashSet<>();
        return twoSumTree(A, B, set) ? 1 : 0;
    }
    private boolean twoSumTree(TreeNode root, int target, Set<Integer> varSet){
        if(root == null){
            return false;
        }
        // x + root.data = target
        // x = target - root.data
        int x = target - root.val;
        if(varSet.contains(x)){
            return true;
        }else{
            varSet.add(root.val);
        }
        
        boolean left = twoSumTree(root.left, target, varSet);
        boolean right = twoSumTree(root.right, target, varSet);
        
        return left || right;
    }
}
