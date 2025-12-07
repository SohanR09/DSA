import java.lang.*;
import java.util.*;

class ClosestPointComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> p1, ArrayList<Integer> p2){
        int dist1 = p1.get(0)*p1.get(0) + p1.get(1)*p1.get(1);
        int dist2 = p2.get(0)*p2.get(0) + p2.get(1)*p2.get(1);
        return Integer.compare(dist1, dist2);
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        Collections.sort(A, new ClosestPointComparator());
        return new ArrayList<>(A.subList(0, B));
    }
}
