import java.util.*;
class DoublyLinkedList
{
static Node head;
static class Node
{
	int data;
	Node next, prev;
	Node(int d)
	{
	data = d;
	next = prev = null;
	}
}

Node sortAKSortedDLL( Node head, int k) {
	if(head == null || head.next == null)
		return head;

	for(Node i = head.next; i != null; i = i.next) {
		Node j = i;
		while(j.prev != null && j.data < j.prev.data) {
			Node temp = j.prev.prev;
			Node temp2 = j.prev;
			Node temp3 = j.next;
			j.prev.next = temp3;
			j.prev.prev = j;
			j.prev = temp;
			j.next = temp2;
			if(temp != null)
				temp.next = j;
			if(temp3 != null)
				temp3.prev = temp2;
		}
		if(j.prev == null)
			head = j;
	}
	return head;
}
void push(int new_data)
{
	Node new_node = new Node(new_data);
	new_node.prev = null;
	new_node.next = head;
	if (head != null)
	{
	head.prev = new_node;
	}
	head = new_node;
}
void printList(Node node)
{
	while (node != null)
	{
	System.out.print(node.data + " ");
	node = node.next;
	}
}

// Driver code
public static void main(String[] args)
{
	DoublyLinkedList list = new DoublyLinkedList();
	list.push(8);
	list.push(56);
	list.push(12);
	list.push(2);
	list.push(6);
	list.push(3);

	int k = 2;

	System.out.println("Original Doubly linked list:");
	list.printList(head);

	Node sortedDLL = list.sortAKSortedDLL(head, k);
	System.out.println("");
	System.out.println("Doubly Linked List after sorting:");
	list.printList(sortedDLL);
}
}
