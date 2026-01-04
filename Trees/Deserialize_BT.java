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
    public TreeNode solve(ArrayList<Integer> A) {
        int n = A.size();

        TreeNode root = new TreeNode(A.get(0));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while(i < n-1 && !q.isEmpty()){
            TreeNode cur = q.poll();

            if(A.get(i) != -1){
                TreeNode temp = new TreeNode(A.get(i));
                cur.left = temp;
                q.add(cur.left);
            }else{
                cur.left = null;
            }

            if(A.get(i+1) != -1){
                TreeNode temp = new TreeNode(A.get(i+1));
                cur.right = temp;
                q.add(cur.right);
            }else{
                cur.right = null;
            }
            i += 2;
        }
        return root;
    }
}
