

class Solution {
    public int partition(ArrayList<Integer> A) {
        // Code Here
        int s = 0;
        int e = A.size();

        int pivot = A.get(e-1);
        
        int l = s;
        int r = e-2;
        while(l <= r){
            if(A.get(l) <= pivot) l++;
            else if(A.get(r) > pivot) r--;
            else {
                int temp = A.get(l);
                A.set(l, A.get(r));
                A.set(r, temp);
            }

        }

        int temp = A.get(e-1);
        A.set(e-1, A.get(l));
        A.set(l, temp);


        return l;
    }
}
