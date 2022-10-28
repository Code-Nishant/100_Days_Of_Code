//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node current= head;
        int arr[]={0,0,0};
        
        while(current!=null){
            
            if(current.data==0){
                arr[0]=arr[0]+1;
            }
            else if(current.data==1){
                arr[1]=arr[1]+1;
            }
            else if(current.data==2){
                arr[2]=arr[2]+1;
            }
            current=current.next;
        }
        
        current=head;
        int i=0;
        
        while(current!=null){
            if(arr[i]==0){
                i++;
            }
            else{
                current.data=i;
                arr[i]=arr[i]-1;
                
                current=current.next;
            }
        }
        return head;
    }
}


