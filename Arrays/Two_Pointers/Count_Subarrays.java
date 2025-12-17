public class Solution {
    public int solve(ArrayList<Integer> A) {
        Set<Integer> set = new HashSet<>();
        long count = 0;
        int i = 0, j = 0, n = A.size();
        int mod = 1000000007;

        while(j < n){
            while (set.contains(A.get(j))) {
                set.remove(A.get(i));
                i++;
            }
            set.add(A.get(j));
            count = (count + j - i + 1) % mod;
            j++;
        }

        return (int)count;
    }
}
