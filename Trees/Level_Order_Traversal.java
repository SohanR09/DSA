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
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(A);

        while(!qu.isEmpty()){
            int size = qu.size();
            ArrayList<Integer> temp = new ArrayList<>();    
            for(int i = 0; i < size; i++){
                TreeNode cur = qu.poll();
                temp.add(cur.val);
                if(cur.left != null){
                    qu.add(cur.left);
                }
                if(cur.right != null){
                    qu.add(cur.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
