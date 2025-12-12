public class Solution {
    public int solve(int A, int B, ArrayList<ArrayList<Integer>> C) {
        // sort rows
        for ( ArrayList<Integer> el: C ) {
            Collections.sort(el);
        }

        int ans = Integer.MAX_VALUE;
        // traverse from 0 -> A-1 rows
        for ( int i = 0; i < A - 1; i++ ) {
            for ( int j = 0; j < B; j++ ) {
                int lB = lowerBound(C.get(i+1), C.get(i).get(j));
                int uB = upperBound(C.get(i+1), C.get(i).get(j));
                int temp1 = Math.abs(C.get(i).get(j) - lB);
                int temp2 = Math.abs(uB - C.get(i).get(j));

                int cur_ans = Math.min(temp1, temp2);
                ans = Math.min(ans, cur_ans);
            }
        }
        return ans;
    }
    private int lowerBound(ArrayList<Integer> A, int target){
        int left = 0, right = A.size()-1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(A.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left < A.size() ? A.get(left) : A.get(A.size() - 1);    
    }
    private int upperBound(ArrayList<Integer> A, int target){
        int left = 0, right = A.size()-1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(A.get(mid) <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right >= 0 ? A.get(right) : A.get(0);
    }
}
