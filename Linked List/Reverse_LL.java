/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {
        if(A.next == null || A == null){
            return A;
        }
        ListNode prev = null;
        ListNode cur = A;

        while(cur != null){
            ListNode forward = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forward;
        }
        A = prev;
        return A;
    }
}
