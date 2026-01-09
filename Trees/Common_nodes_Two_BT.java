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
    public int solve(TreeNode A, TreeNode B) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        inOrderTraversal(A, list);
        inOrderTraversal(B, set);

        long sum = 0;
        int mod = 1000000007;


        for (int num : list) {
            if (set.contains(num)) {
                sum = (sum + num) % mod;
            }
        }

        return (int)sum;
    }
    private void inOrderTraversal(TreeNode root, List<Integer> orderArr){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left, orderArr);
        orderArr.add(root.val);
        inOrderTraversal(root.right, orderArr);
    }
    private void inOrderTraversal(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        inOrderTraversal(root.left, set);
        set.add(root.val);
        inOrderTraversal(root.right, set);
    }
}
