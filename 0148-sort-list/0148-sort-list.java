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
    public ListNode sortList(ListNode head) {
        // //base case
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode middle= find_middle(head);
        ListNode newhead= middle.next;
        middle.next=null;
        
        ListNode left= sortList(head);
        ListNode right= sortList(newhead);
        
        return Merging(left, right);
    }
    
    public ListNode find_middle(ListNode head) {
         ListNode fast= head;
         ListNode slow=head;
         
         while(fast.next!=null && fast.next.next!=null){
                 slow=slow.next;
                 fast=fast.next.next;
             }
        return slow;
     }
    
     public ListNode Merging(ListNode left,ListNode right) {         
        ListNode result = null;

        if (left == null)
            return right;
        if (right == null)
            return left;
 
        if (left.val < right.val) {
            result = left;
            result.next =Merging(left.next,right);
        }
        else {
            result = right;
            result.next =Merging(left, right.next);
        }
 
        return result;
     }
}