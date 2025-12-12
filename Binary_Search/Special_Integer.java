public class Solution {
    private boolean isValid(ArrayList<Integer> A, int mid, int B){

        long sum = 0;
        for(int i = 0; i < mid; i++){
            sum += A.get(i);
        }
        if(sum > B) return false;

        for(int i = mid; i < A.size(); i++){
            sum = sum - A.get(i - mid) + A.get(i);
            if(sum > B) return false;
        }
        return true;
    }
    public int solve(ArrayList<Integer> A, int B) {
        int s = 1;
        int e = A.size();
        int ans = 0;

        while(s <= e){
            int mid = s + (e - s) / 2;
            if(isValid(A, mid, B)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
}
