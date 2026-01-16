public class Solution {
    public ArrayList<Integer> sortSubarray(ArrayList<Integer> A, int B, int C) {
        mergesort(A, B, C);
        return A;
    }

    private void mergesort(ArrayList<Integer> A, int l, int r){
        if ( l == r ) return;
        int mid = (l + r) / 2;
        mergesort(A, l, mid);
        mergesort(A, mid + 1, r);
        merge(A, l, mid, r);
    }

    private void merge(ArrayList<Integer> A, int l, int mid, int r){
        int i = l;
        int j = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();

        while(i <= mid && j <= r){
            if(A.get(i) <= A.get(j)){
                temp.add(A.get(i));
                i++;
            }else{
                temp.add(A.get(j));
                j++;
            }
        }

        while(i <= mid){
            temp.add(A.get(i));
            i++;
        }
        while(j <= r){
            temp.add(A.get(j));
            j++;
        }

        for(int k = 0, a = l; k < temp.size(); k++, a++){
            A.set(a, temp.get(k));
        }
    }
}
