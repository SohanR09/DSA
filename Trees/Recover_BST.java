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
    public ArrayList<Integer> recoverTree(TreeNode A) {
        TreeNode prev = null; // Previous node in inorder traversal
        TreeNode first = null; // First node violating BST property
        TreeNode second = null; // Second node violating BST property
        
        TreeNode cur = A;
        while(cur != null){
            if(cur.left == null){
                if (prev != null && cur.val < prev.val) { 
                    if (first == null) { 
                        first = prev; second = cur; 
                    } else { 
                        second = cur; 
                    } 
                } 
                prev = cur;
                cur = cur.right;
            }else{

                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    if (prev != null && cur.val < prev.val) { 
                        if (first == null) { 
                            first = prev; second = cur; 
                        } else { 
                            second = cur; 
                        } 
                    } 
                    prev = cur;
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(first.val);
        result.add(second.val);
        Collections.sort(result);
        return result;
    }
}
