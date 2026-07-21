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

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of every list
        for (ListNode head : lists) {

            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode curr = pq.poll();

            // Add it to answer
            tail.next = curr;
            tail = tail.next;

            // Add next node of the same list
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }
}