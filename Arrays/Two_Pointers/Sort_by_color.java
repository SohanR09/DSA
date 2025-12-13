public class Solution {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int n = A.size();
        if(n <= 1){
            return A;
        }

        ArrayList<Integer> feqArray = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            feqArray.add(0);
        }

        for(int i = 0; i < n ; i++){
            feqArray.set(A.get(i), feqArray.get(A.get(i)) + 1);
        }

        int idx = 0;
        for(int i = 0; i < feqArray.size(); i++){
            if(feqArray.get(i) == 0) continue;
            int temp = feqArray.get(i);
            for(int j = 0; j < temp; j++){
                A.set(idx, i);
                idx++;
            }
        }
        return A;
    }
}
