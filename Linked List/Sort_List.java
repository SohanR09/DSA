/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode A) {
        return mergeSort(A);
    }
    public ListNode mergeSort(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        // split ListNode into half
        ListNode temp = A;
        ListNode slow = temp, fast = temp, prev = null;
        while (slow != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = prev;
        ListNode secondHalf = middle.next;
        middle.next = null;

        ListNode left = mergeSort(A);
        ListNode right = mergeSort(secondHalf);

        return merge(left, right);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }
    public ListNode 
}
