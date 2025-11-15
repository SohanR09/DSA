/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode dummy = new ListNode(0);
    public ListNode cur = null;
    public int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode a1 = l1;
        ListNode a2 = l2;

        while (a1 != null) {
            s1.push(a1.val);
            a1 = a1.next;
        }
        while (a2 != null) {
            s2.push(a2.val);
            a2 = a2.next;
        }

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();

            int nVal = n1 + n2 + carry;
            carry = nVal / 10;

            ListNode node = new ListNode(nVal % 10);
            node.next = cur;
            cur = node;

        }

        return cur;
    }
}