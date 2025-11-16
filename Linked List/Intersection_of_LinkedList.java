/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode A, ListNode B) {
        int n = 0;
        ListNode tempA = A;
        while (tempA != null) {
            n++;
            tempA = tempA.next;
        }
        int m = 0;
        ListNode tempB = B;
        while (tempB != null) {
            m++;
            tempB = tempB.next;
        }

        while (A != null && B != null) {
            if (n > m) {
                A = A.next;
                n--;
            } else if (m > n) {
                B = B.next;
                m--;
            } else {
                if (A == B) {
                    return A;
                } else {
                    A = A.next;
                    B = B.next;
                }
            }
        }

        return null;
	}
}