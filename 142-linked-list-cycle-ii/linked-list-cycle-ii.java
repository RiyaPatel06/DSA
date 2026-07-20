/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        //finding cycle
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        // no cycle
        if(fast==null || fast.next==null) return null;
        // Step 2: Find starting point of cycle
        slow = head;

        while (slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow;
        
    }
}