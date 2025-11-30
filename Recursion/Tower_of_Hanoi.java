public class Solution {
    private void TOH(int A, int source, int helper, int des, ArrayList<ArrayList<Integer>> result){
        if(A == 0) return;
        TOH(A-1, source, des, helper, result);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(A);        // disk
        temp.add(source);   // source
        temp.add(des);      // destination
        result.add(temp);
        TOH(A-1, helper, source, des, result);
    }
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        TOH(A, 1, 2, 3, result);
        return result;

    }
}
