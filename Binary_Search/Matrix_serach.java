public class Solution {
    public int searchMatrix(int[][] A, int target) {
        int n = A.length;
        int m = A[0].length;

        int s = 0;
        int e = n * m - 1;

        while(s <= e){
            int mid = s + (e - s) /2;
            int row = mid / m;
            int col = mid % m;
            int val = A[row][col];
            
            if(val == target){
                return 1;
            }else if(val < target){
                s = mid + 1;
            }else if(val > target){
                e = mid - 1;
            }
        }
        return 0;
    }
}
