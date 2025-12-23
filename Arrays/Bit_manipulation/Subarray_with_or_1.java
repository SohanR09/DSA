public class Solution {
    public int subarraysWithOR1(ArrayList<Integer> A) {
        int n = A.size();
        int countZeros = 0;
        int ansZeros = 0;

        for(int i = 0; i < n; i++){
            if(A.get(i) == 0){
                countZeros++;
            }else{
                ansZeros += (countZeros * (countZeros + 1)) / 2;
                countZeros = 0;
            }
        }
        ansZeros += (countZeros * (countZeros + 1)) / 2;
        int total = n * (n + 1) /2;

        return total - ansZeros;
    }
}
