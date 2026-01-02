public class Solution {
    private void printNum(ArrayList<Integer> A, int idx){
        if(idx == A.size()) return;
        System.out.print(A.get(idx) + " ");
        printNum(A, idx+1);
    }
    public void PrintArray(ArrayList<Integer> A) {
        printNum(A, 0);
        System.out.println();
    }
}
