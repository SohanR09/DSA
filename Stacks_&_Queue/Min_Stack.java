import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

class Solution {
    ArrayList<Integer> A = new ArrayList<>();
    ArrayList<Integer> minArr = new ArrayList<>();
    
    int idx = -1;
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        min = Math.min(min, x);
        idx++;
        minArr.add(min);
        A.add(x);
    }

    public void pop() {
        if(idx >= 0){
            A.remove(idx);
            minArr.remove(idx);
            idx--;
            if(idx >= 0) min = minArr.get(idx);
            else min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if(idx == -1) return -1;
        return A.get(idx);
    }

    public int getMin() {
        if(idx == -1) return -1;
        return minArr.get(idx);
    }
}
