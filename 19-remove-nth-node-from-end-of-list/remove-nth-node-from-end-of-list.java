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
    public int length(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=length(head);
        //if head needs to be removed
        if(n==count){
            return head.next;
        }
        int idx=count-n;
        ListNode temp=head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;

        }
        temp.next=temp.next.next;
        
        return head;
        
    }
}