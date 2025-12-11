    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        private int findPivot(List<Integer> A, int s, int e){
            while(s<=e){
                if(A.get(s) <= A.get(e)){
                    return s;
                }

                int mid = s + (e - s) / 2;

                if(A.get(mid) > A.get(e)){
                    s = mid + 1;
                }else {
                    e = mid;
                }
            }

            return s;
        }
        private int binarySearch(List<Integer> A, int s, int e, int target){
            while(s <= e){
                int mid  = s + (e - s) / 2;

                if(A.get(mid) > target){
                    e = mid - 1;
                }else if(A.get(mid) < target){
                    s = mid + 1;
                }else if(A.get(mid) == target){
                    return mid;
                }
            }
            return -1;
        }
        public int search(final List<Integer> A, int B) {
            int n = A.size();
            int pivot_idx = findPivot(A, 0, n - 1);

            if(A.get(pivot_idx) == B){
                return pivot_idx;
            }

            if(pivot_idx == 0){
                return binarySearch(A, 0, n - 1, B);
            }

            if(A.get(0) < B) {
                return binarySearch(A, 0, pivot_idx - 1, B);
            }else if(A.get(0) > B){
                return binarySearch(A, pivot_idx, n-1, B);
            }else if(A.get(0) == B){
                return 0;
            }
            return -1;
        }
    }
