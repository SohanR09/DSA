/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while( A != null && B != null ) {
            if (A.val > B.val) {
                cur.next = B;
                B = B.next;
            } else {
                cur.next = A;
                A = A.next;
            }
            cur = cur.next;
        }
        if ( A != null ) {
            cur.next = A;
        }
        if ( B != null ) {
            cur.next = B;
        }
        
        return dummy.next;
    }
}
