// sliding window approach
// with TC: O(N);

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (n == 1 && A.get(0) == B) {
            return A;
        }

        ArrayList<Integer> result = new ArrayList<>();

        int curSum = 0;
        int i = 0, j = 0;

        while (j < n) {
            // check the curSum with the target
            if (curSum + A.get(j) == B) {
                break;
            }

            // adjust the curSum based on the window
            if (curSum + A.get(j) < B) {
                curSum += A.get(j);
                j++;
            } else if (curSum + A.get(j) > B) {
                curSum -= A.get(i);
                i++;
            }
        }

        // check for the continues subarray
        if (j < n) {
            for (int k = i; k <= j; k++) {
                result.add(A.get(k));
            }
        }

        // not found
        if (result.size() == 0) {
            result.add(-1);
        }

        return result;
    }
}
