public class Solution {
    public int candy(ArrayList<Integer> A) {
        int n = A.size();

        ArrayList<Integer> candies = new ArrayList<>();
        for (int el: A) {
            candies.add(1);
        }

        for (int i = 1; i < n; i++) {
            if (A.get(i) > A.get(i-1)) {
                candies.set(i, candies.get(i-1) + 1);
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (A.get(i) > A.get(i+1) && candies.get(i) < candies.get(i+1) + 1) {
                candies.set(i, candies.get(i+1) + 1);
            }
        }

        int totalCandies = 0;
        for (int el: candies) {
            totalCandies += el;
        }

        return totalCandies;
    }
}
