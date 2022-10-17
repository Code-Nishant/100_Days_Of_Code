/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one=headA;
        ListNode two=headB;
        
        int c1=0;
        int c2=0;
        
        while(one!=null){
            c1++;
            one=one.next;
        }
        while(two!=null){
            c2++;
            two=two.next;
        }
        
        int diff=Math.abs(c1-c2);
        one=headA;
        two=headB;
        
        if(c1>c2){
            for(int i=0;i<diff; i++){
                one=one.next;
            }
        }
        if(c1<c2){
            for(int i=0;i<diff; i++){
                two=two.next;
            }
        }
        
        while(one!=two){
            one=one.next;
            two=two.next;
        }
        if(one==two){
            return one;
        }
        else{
            return null;
        }
    }
}