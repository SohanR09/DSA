public class Solution {

    public String solve(int[] A) {
        boolean ans = checkValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        return ans ? "YES" : "NO";
    }

    private boolean checkValidBST(int[] A, int min, int max, int idx){
        if(idx == A.length){
            return true;
        }
        if (A[idx] < min || A[idx] > max) {
            return false;
        }
        if (idx + 1 < A.length && A[idx + 1] < A[idx]) {
            // Next node is left child
            return checkValidBST(A, min, A[idx] - 1, idx + 1);
        } else {
            // Next node is right child
            return checkValidBST(A, A[idx] + 1, max, idx + 1);
        }
    }
}
