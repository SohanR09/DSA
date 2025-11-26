
public class Solution {
    public int solve(ListNode A, int B) {
        ListNode temp = A;

        int i = 0;
        while(i < B && temp != null){
            temp = temp.next;
            i++;
        }
        return temp == null ? -1 : temp.val;
    }
}
