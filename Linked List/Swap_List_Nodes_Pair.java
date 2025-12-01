public class Solution {
    public ListNode swapPairs(ListNode A) {
        ListNode start = new ListNode(0);
        start.next = A;
        ListNode cur = start;

        while(cur.next != null && cur.next.next != null){
            cur.next = swapNodes(cur.next, cur.next.next);
            cur = cur.next.next;
        }

        return start.next;
    }
    private ListNode swapNodes(ListNode l1, ListNode l2){
        l1.next = l2.next;
        l2.next = l1;
        return l2;
    }
}
