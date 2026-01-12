public class Solution {
    public int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        List<Integer> lists = new ArrayList<>();

        while(A != 0){
            int digit = A % 10;
            lists.add(digit);
            A = A / 10;
        }

        // Collections.reverse(lists);

        int n = lists.size();
        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = i; j < n; j++){
                product *= lists.get(j);
                if(set.contains(product)){
                    return 0;
                }
                set.add(product);
            }
        }
        return 1;
    }
}
