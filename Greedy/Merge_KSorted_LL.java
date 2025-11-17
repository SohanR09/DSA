/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> A) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode node: A) {
            pq.offer(node);
        }

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();

            cur.next = minNode;
            cur = cur.next;

            if (minNode.next != null) pq.offer(minNode.next);
        }

        return dummy.next;
	}
}
