public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int i = 0, j = n-1;
        long count = 0;
        int mod = 1000000007;

        while(i <= j){
            long sum = (long)A[i] + A[j];
            if(sum > B){
                j--;
            }else if(sum < B){
                i++;
            }else{
                long x = A[i], cntI = 0;
                while(i <= j && A[i] == x){
                    cntI++;
                    i++;
                }
                
                long y = A[j], cntJ = 0;
                while(j >= i && A[j] == y){
                    cntJ++;
                    j--;
                }

                if(x == y){
                    long temp = cntI + cntJ;
                    count = (count + (temp * (temp - 1) / 2)) % mod;
                }else{
                    count = (count + cntI * cntJ) % mod;
                }
            }
        }

        return (int)count;
    }
}
