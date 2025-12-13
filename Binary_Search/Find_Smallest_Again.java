public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        
        int low = 3, high = 0;
        for (int num : A) {
            low = Math.min(low, num);
            high += num;
        }

        while(low <= high){
            int mid = (low + high) >> 1;
            if(countTriplets(A, mid) > B-1){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }
    private int countTriplets(ArrayList<Integer> A, int mid){
        int n = A.size();
        int count = 0;

        for(int i = 0; i < n-2; i++){
            for(int j = i + 1; j < n-1; j++){
                int remainingSum = mid - (A.get(i) + A.get(j));
                int k = lowerBound(A, remainingSum);

                count += Math.max(0, k - (j + 1));
            }
        }
        return count;
    }
    private int lowerBound(ArrayList<Integer> A, int target){
        int low = 0, high = A.size() - 1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(A.get(mid) <= target){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return low;
    }
}
