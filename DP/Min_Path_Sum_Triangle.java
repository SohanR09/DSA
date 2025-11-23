public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size(), m = a.get(0).size();
        if ( n == 0 ) return 0;
        if ( n == 1 && m == 1 ) return a.get(0).get(0);

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<Integer>());
            for (int j = 0; j < a.get(i).size(); j++) {
                dp.get(i).add(0);
            }
        }
        
        dp.get(0).set(0, a.get(0).get(0));

        for (int i = 1; i < n; i++) {
            m = a.get(i).size();

            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp.get(i).set(j, dp.get(i-1).get(j) + a.get(i).get(j));
                } else if (j == m-1) {
                    dp.get(i).set(j, dp.get(i-1).get(j-1) + a.get(i).get(j));
                } else {
                    dp.get(i).set(j, Math.min(dp.get(i-1).get(j-1), dp.get(i-1).get(j)) + a.get(i).get(j));
                }
            }
        }

        int size = dp.get(n-1).size();
        int minVal = Integer.MAX_VALUE;

        for (int k = 0; k < size; k++) {
            minVal = Math.min(minVal, dp.get(n-1).get(k));
        }

        return minVal;
	}
}
