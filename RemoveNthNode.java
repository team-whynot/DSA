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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode first = head,second = head;
        while(n>0){
            first = first.next;
            n--;
        }
        if(first == null) return head.next;
        while(first.next != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
        
    }
}