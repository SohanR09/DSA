/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        
        ListNode slow = A, fast = A, prev = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // loop found
            if (slow == fast) {
                slow = A;

                while (slow != fast) {
                    prev = fast;
                    slow = slow.next;
                    fast = fast.next;
                }

                // break the loop
                prev.next = null;
            }
        }

        return A;
    }
}
