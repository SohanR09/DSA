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
    private int postOrderTrv(TreeNode root, boolean[] res){
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return root.val;
        }
        int lsum = postOrderTrv(root.left, res);
        int rsum = postOrderTrv(root.right, res);
        
        if (res[0] && lsum + rsum != root.val) {
            res[0] = false;
        }
        return root.val + lsum + rsum;
    }
    public int solve(TreeNode A) {
        boolean[] res = new boolean[1];
        res[0] = true;
        postOrderTrv(A, res);
        return res[0] ? 1 : 0;
    }
}
