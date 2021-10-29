/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        
        ListNode head = null,temp = null;
        if(lists.length == 0 || lists == null){
            return head;
        }
        int flag = 0;
        while(flag == 0){
            int tempVal = 0;
            flag = 1;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<lists.length;i++){
                ListNode h = lists[i];
                if(h != null){
                        if(h.val < min){
                        flag = 0;
                        min = h.val;
                        tempVal = i;
                    }
                }
                
            }
            ListNode ll = lists[tempVal];
            if(head == null){
                head = ll;
                temp = head;
            }
            else{
                temp.next = ll;
                temp = temp.next;
                
                
            }
            // System.out.println(ll.val);
            try{
                lists[tempVal] = ll.next;
            }catch(Exception e){
                
            }
            // if(ll.next == null){
            //     lists[tempVal] = null;
            // }
            // else
            //     lists[tempVal] = ll.next;
            
        }
        return head;

        
        
        
        
    }
}