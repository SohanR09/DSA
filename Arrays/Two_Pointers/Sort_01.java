public class Solution {
    private int partition(ArrayList<Integer> A, int s, int e){
        int pivot = A.get(s);
        int l = s + 1;
        int r = e;

        while(l <= r){
            if(A.get(l) <= pivot) l++;
            else if(A.get(r) > pivot) r--;
            else{
                int temp = A.get(l);
                A.set(l, A.get(r));
                A.set(r, temp);
            }
        }

        int temp = A.get(s);
        A.set(s, A.get(r));
        A.set(r, temp);

        return r;
    }
    // recursion used for the sorting using the partition index
    private void qicksort(ArrayList<Integer> A, int s, int e){
        if(s >= e) return;
        int pivot_idx = partition(A, s, e);
        qicksort(A, s, pivot_idx - 1);
        qicksort(A, pivot_idx + 1, e);
    }
    public ArrayList<Integer> sort01(ArrayList<Integer> A) {
        qicksort(A, 0, A.size() - 1);
        return A;
    }
}
