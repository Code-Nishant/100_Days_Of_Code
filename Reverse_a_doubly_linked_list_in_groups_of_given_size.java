import java.io.*;
import java.util.*;
class Node {
	int data;
	Node next, prev;
}

class GFG {
	static Node getNode(int data)
	{
		Node new_node = new Node();
		new_node.data = data;
		new_node.next = new_node.prev = null;

		return new_node;
	}
	
	static Node push(Node head, Node new_node)
	{
		new_node.prev = null;
		new_node.next = head;
		if (head != null)
			head.prev = new_node;
		head = new_node;
		return head;
	}

	static Node revListInGroupOfGivenSize(Node head, int k)
	{
		if (head == null)
			return head;
		Node st = head;
		Node globprev = null;
		Node ans = null;
		while (st != null) {

			int count = 1;
			Node curr = st;
			Node prev = null;
			Node next = null;
			while (curr != null&& count <= k) {
				next = curr.next;
				curr.prev = next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			if (ans == null) {
				ans = prev; 
				ans.prev = null;
			}
			if (globprev == null) {
				globprev = st; 
			}
			else {
				globprev.next = prev;
				prev.prev
					= globprev; 
				globprev = st;
			}

			st = curr;
		}
		return ans;
	}
	
	static void printList(Node head)
	{
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	// Driver code
	public static void main(String args[])
	{
		// Start with the empty list
		Node head = null;

		// Create doubly linked: 10<->8<->4<->2
		head = push(head, getNode(2));
		head = push(head, getNode(4));
		head = push(head, getNode(8));
		head = push(head, getNode(10));

		int k = 2;

		System.out.print("Original list: ");
		printList(head);

		// Reverse doubly linked list in groups of
		// size 'k'
		head = revListInGroupOfGivenSize(head, k);

		System.out.print("\nModified list: ");
		printList(head);
	}
}
