/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    static class Node {
        int data;
        Node next, prev;
    };
    
    static int countPairs(Node first, Node second, int value){
    int count = 0;
   
    while (first != null && second != null && first != second && second.next != first) {
   
        if ((first.data + second.data) == value) {
            count++;
            first = first.next;
            second = second.prev;
        }
        else if ((first.data + second.data) > value)
            second = second.prev;
        else
            first = first.next;
    }
    return count;
}
   
static int countTriplets(Node head, int x)
{
    if (head == null)
        return 0;
   
    Node current, first, last;
    int count = 0;
    last = head;
    while (last.next != null)
        last = last.next;
    for (current = head; current != null; current = current.next) {
        first = current.next;
        count += countPairs(first, last, x - current.data);
    }
    return count;
}
static Node insert(Node head, int data)
{
    Node temp = new Node();
    temp.data = data;
    temp.next = temp.prev = null;
   
    if ((head) == null)
        (head) = temp;
    else {
        temp.next = head;
        (head).prev = temp;
        (head) = temp;
    }
    return head;
}
    
    
    
    
	public static void main (String[] args) {
	Node head = null;
   
    // insert values in sorted order
    head = insert(head, 9);
    head = insert(head, 8);
    head = insert(head, 6);
    head = insert(head, 5);
    head = insert(head, 4);
    head = insert(head, 2);
    head = insert(head, 1);
   
    int x = 17;
   
    System.out.print("Count = " + countTriplets(head, x));
	}
}
