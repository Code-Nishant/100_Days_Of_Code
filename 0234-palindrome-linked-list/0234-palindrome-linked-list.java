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
    public static ListNode reverse(ListNode ptr) {
        ListNode pre=null;
        ListNode nex=null;
        while(ptr!=null) {
            nex = ptr.next;
            ptr.next = pre;
            pre=ptr;
            ptr=nex;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        
        while(slow!=null) {
            if(dummy.val != slow.val) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         //base case
//         if(head== null||head.next==null){
//             return true;
//         }
//         ListNode mid=middle(head);
//         ListNode last= reverse(mid.next);
//         ListNode current= head;
        
//         while(last!=null){
//             if(last.val!=current.val){
//                 return false;
//             }
//             current=current.next;
//             last=last.next;
//         }
//         return true; 
//     }
//     public ListNode middle(ListNode head) {
//         ListNode slow=head;
//         ListNode fast= head;
        
//         while(fast!=null&& fast.next!= null){
//             slow=slow.next;
//             fast= fast.next.next;
//         }
//         return slow;
//     }
//     public ListNode reverse(ListNode head){
//         ListNode curr=null;
//         ListNode prev=null;
        
//         while(curr!=null){
//             ListNode temp= curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=temp;
//         }
//         return prev;
    }
}