import java.util.*;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int leftmost = leftMostIndex(A, B);
        int rightmost = rightMostIndex(A, B);

        return new ArrayList<>(Arrays.asList(leftmost, rightmost));
    }

    private int leftMostIndex(List<Integer> A, int B){
        int n = A.size();
        int s = 0;
        int e = n -1;
        int result = -1;

        while(s <= e){
            int midIdx = s + (e - s) / 2;
            int mid = A.get(midIdx);
            if(mid == B){
                result = midIdx;
                e = midIdx - 1;
            }else if(mid < B){
                s = midIdx + 1;
            }else{
                e = midIdx - 1;
            }
        }

        return result;
    }

    private int rightMostIndex(List<Integer> A, int B){
        int n = A.size();
        int s = 0;
        int e = n -1;
        int result = -1;

        while(s <= e){
            int midIdx = s + (e - s) / 2;
            int mid = A.get(midIdx);
            if(mid == B){
                result = midIdx;
                s = midIdx + 1;
            }else if(mid < B){
                s = midIdx + 1;
            }else{
                e = midIdx - 1;
            }
        }
        
        return result;
    }
}
