public class Solution {
    public int solve(int A) {
        int s = 1;
        int e = A;
        int ans = 0;

        while(s <= e){
            int mid = s + (e - s) / 2;
            if (mid + 1 <= (2 * A)/mid) {
                ans = mid;
                s = mid + 1;
            }else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
