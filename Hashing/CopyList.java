/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;

        // step 1
        // create clones
        RandomListNode cur1 = head;
        while(cur1 != null){
            RandomListNode cloned = new RandomListNode(cur1.label);
            cloned.next = cur1.next;
            cur1.next = cloned;
            cur1 = cloned.next;
        }

        // step 2
        // assign random pointers
        RandomListNode cur2 = head;
        while(cur2 != null){
            if(cur2.random != null){
                cur2.next.random = cur2.random.next;
            }
            cur2 = cur2.next.next;
        }

        // step 3
        // delete originals
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = head;
        RandomListNode copy = dummy;

        while(cur != null){
            copy.next = cur.next;
            cur = cur.next.next;
            copy = copy.next;
        }

        head = dummy.next;
        return head;
    }
}
