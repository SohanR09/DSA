public class Solution {
    public int sqrt(int A) {
        if(A == 1) return A;

        int s = 1;
        int e = A;
        int ans = 0;
        while(s <= e){
            int mid = s + (e-s)/ 2;

            if(mid == A / mid){
                return mid;
            }else if(mid != 0 && mid < A / mid){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
}
