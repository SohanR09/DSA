public class Solution {
    private void revereArr(ArrayList<Integer> arr){
        int s = 0;
        int e = arr.size() - 1;
        while(s < e){
            int temp = arr.get(s);
            arr.set(s, arr.get(e));
            arr.set(e, temp);
            s++;
            e--;
        }
    }
    public int colorful(int A) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();

        while(A != 0){
            arr.add(A % 10);
            A = A / 10;
        }
        revereArr(arr);

        // for(int len = 1; len <= arr.size(); len++) {  // window size
        //     for(int i = 0; i <= arr.size()-len; i++) { // window start
        //         int product = 1;
        //         for(int j = i; j < i+len; j++) {  // calculate product within window
        //             product *= arr.get(j);
        //         }
        //         if(!set.add(product)) return 0;
        //     }
        // }
        int n = arr.size();
        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = i; j < n; j++){
                product *= arr.get(j);
                if(set.contains(product)){
                    return 0;
                }
                set.add(product);
            }
        }

        return 1;
    }
}
