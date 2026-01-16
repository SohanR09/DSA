import java.util.*;

class FactorComparatorAsc implements Comparator<Integer>{
    public int compare(Integer n1, Integer n2){
        int factorA = Solution.countFactors(n1);
        int factorB = Solution.countFactors(n2);
        if(factorA < factorB) return -1;
        else if(factorA > factorB) return 1;
        if(n1 < n2) return -1;
        else if(n1 > n2) return 1;
        return 0;
    }
}
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        sortOnFacAsc(A);
        return A;
    }
    public static void sortOnFacAsc(ArrayList<Integer> A){
        Collections.sort(A, new FactorComparatorAsc());
    }
    public static int countFactors(int n){
        int count = 0;
        for(int i = 1; i < n; i++){
            if(n % i == 0){
                count++;
            }
        }
        return count;
    }
}
