/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1; // Empty list or single-element list is a palindrome
        }

        ListNode temp = A;

        // get middle node
        ListNode middle = getMiddleNode(temp);
        // seperate the middle from the 1st have
        ListNode otherHalf = middle.next;
        middle.next = null;         // now break

        ListNode sendHalf = reverseList(otherHalf);

        while (sendHalf != null && temp != null) {
            if (sendHalf.val != temp.val) {
                return 0;
            }
            sendHalf = sendHalf.next;
            temp = temp.next;
        }
        return 1;
    }
    public ListNode reverseList(ListNode root) {
        ListNode prev = null, cur = root, next = root;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
    public ListNode getMiddleNode(ListNode root) {
        ListNode prev = null, slow = root, fast = root;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }
}
