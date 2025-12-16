public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int m = B.size();
        ArrayList<Integer> ans = new ArrayList<>(n + m);

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n && j < m){
            if(A.get(i) <= B.get(j)){
                ans.add(k, A.get(i));
                i++;
                k++;
            }else if(A.get(i) > B.get(j)){
                ans.add(k, B.get(j));
                j++;
                k++;
            }
        }

        while(i < n){
            ans.add(k, A.get(i));
            i++;
            k++;
        }
        while(j < m){
            ans.add(k, B.get(j));
            j++;
            k++;
        }
        return ans;
    }
}
