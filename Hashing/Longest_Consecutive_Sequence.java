public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        int ans = 1;
        Set<Integer> set = new HashSet<Integer>();
        for(int el: A){
            set.add(el);
        }
        int n = A.size();
        for(int cur: A){
            if(!set.contains(cur-1)){
                int curAns = 1;
                while(set.contains(cur+1)){
                    cur++;
                    curAns++;
                }
                ans = Math.max(ans, curAns);
            }
        }
        return ans;
    }
}
