import java.util.*;
class sortTenDigitComparator implements Comparator<Integer>{
    public int compare(Integer n1, Integer n2){
        int digit1 = (n1 / 10) % 10;
        int digit2 = (n2 / 10) % 10;

        if(digit1 > digit2) return 1;
        else if(digit1 < digit2) return -1;
        
        if(n1 > n2) return -1;
        else if(n1 < n2) return 1;
        return 0;
    }
}
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new sortTenDigitComparator());
        return A;
    }
}
