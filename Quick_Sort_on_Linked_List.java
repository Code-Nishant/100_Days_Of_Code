class GfG
{
    public static Node quickSort(Node node)
    {
        //Your code here
        //base case
        if(node==null|| node.next==null){
            return node;
        }
        
        Node head= node;
        Node tail=getTail(head);
        return quickSort(head,tail);
    }
    
    public static Node quickSort(Node head, Node tail){
         if(head==null || tail==null || head==tail){
             return head;
         }
         else{
             Node pivot= partition(head, tail);
             quickSort(head,pivot);
             quickSort(pivot.next,tail);
             
             return head;
         }
     }
     
    public static Node getTail(Node head){
        Node temp= head;
        while(temp!=null && temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    public static Node partition(Node head, Node tail){
        Node pivot=head;
        Node current = head.next;
        Node prev= head;
        
        while(current!= tail.next){
            if(pivot.data>current.data){
                int temp= prev.next.data;
                prev.next.data=current.data;
                current.data=temp;
                // Collections.swap(prev.next.data, current.data);
                prev=prev.next;
            }
            current=current.next;
        }
        int temp=prev.data;
        prev.data=pivot.data;
        pivot.data=temp;
        // Collections.swap(prev.data,pivot.data);
        return prev;
    }
}
