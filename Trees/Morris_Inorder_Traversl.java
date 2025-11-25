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
    public ArrayList<Integer> solve(TreeNode A) {
        if (A == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curNode = A;
        while (curNode != null) {
            if (curNode.left == null) {
                result.add(curNode.val);
                curNode = curNode.right;
            } else {
                TreeNode tempNode = curNode.left;

                while (tempNode.right != null && tempNode.right != curNode) {
                    tempNode = tempNode.right;
                }

                if (tempNode.right == null) {
                    tempNode.right = curNode;
                    curNode = curNode.left;
                } else {
                    tempNode.right = null;
                    result.add(curNode.val);
                    curNode = curNode.right;
                }

            }
        }

        return result;
    }
}
