public class Solution {
    public int solve(ArrayList<Integer> A) {
        int ans = 0, n = A.size();
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(mid == n - 1) 
                return A.get(n-1);
            if(A.get(mid) == A.get(mid + 1)) 
                mid++;
            // if all elements with index < mid are occuring twice then mid should be odd
            if(mid%2 == 1)
                low = mid + 1;
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return A.get(ans);

        // while(s <= e){
        //     int mid = s + (e - s) / 2;

        //     if(mid == 0 || mid == n-1 || (A.get(mid) != A.get(mid - 1) && A.get(mid) != A.get(mid + 1))){
        //         return A.get(mid);
        //     }else if(A.get(mid) == A.get(mid - 1)){
        //         if((mid - 1) % 2 == 0){
        //             s = mid + 1;
        //         }else{
        //             e = mid - 2;
        //         }
        //     }else if(A.get(mid) == A.get(mid + 1)){
        //         mid++;
        //         if(mid % 2 == 0){
        //             s = mid + 2;
        //         }else{
        //             e = mid - 1;
        //         }
        //     }
        // }
        // return A.get(s);
    }
}
