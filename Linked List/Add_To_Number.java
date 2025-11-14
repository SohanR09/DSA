// TC: O(n)
// SC: O(1)
class Solution {
    public ListNode dummy = new ListNode(0);
    public ListNode cur = dummy;

    public int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // get the head val till null
        while (l1 != null || l2 != null) {
            // if null -> use 0
            int node1 = l1 == null ? 0 : l1.val;
            int node2 = l2 == null ? 0 : l2.val;
            // add vals
            int node = node1 + node2;
            // add carry
            int curVal = (node + carry) % 10 ;

            // create a next node
            cur.next = new ListNode(curVal);
            cur = cur.next;                 // switch to next node

            // update the carry variable
            carry = (node + carry) / 10;

            // move the two heads forward
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        // add carry to the list end
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}