/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A) {
        ListNode prev = null, cur = A;
        int ans = 0;

        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = prev;

            ans = Math.max(ans, 2 * count(cur, nxt));
            ans = Math.max(ans, 2 * count (prev, nxt) + 1);

            prev = cur;
            cur = nxt;
        }

        return ans;
    }
    private int count(ListNode A, ListNode B){
        int sum = 0;
        while(A != null && B != null){
            if(A.val != B.val){
                break;
            }
            sum++;
            A = A.next;
            B = B.next;
        }
        return sum;
    }
}
