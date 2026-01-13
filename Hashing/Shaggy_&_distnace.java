public class Solution {
    public int solve(ArrayList<Integer> A) {
        if ( A.size() < 1 ) return -1;
        int n = A.size();
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < n; i++ ) {
            if ( map.containsKey(A.get(i)) ) {
                minDistance = Math.min(minDistance, Math.abs(map.get(A.get(i)) - i));
            }
            map.put(A.get(i), i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
