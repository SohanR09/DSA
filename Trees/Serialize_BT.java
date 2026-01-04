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
    public ArrayList<Integer> solve(TreeNode A) {
        // why linked list?
        // becasue it can store null values,
        // which is not possible in array deque
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.add(A);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();

                if (cur == null) {
                    result.add(-1);
                } else {
                    result.add(cur.val);
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
        }

        return result;
    }
}
