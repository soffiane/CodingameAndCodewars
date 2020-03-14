package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Day 15 : Linked List
 *
 * A Node class is provided for you in the editor. A Node object has an integer data field, DATA , and a Node instance pointer, NEXT , pointing to another node (i.e.: the next node in a list).
 * A Node insert function is also declared in your editor. It has two parameters: a pointer, HEAD, pointing to the first node of a linked list,
 * and an integer DATA value that must be added to the end of the list as a new Node object.
 *
 * Task
 * Complete the insert function in your editor so that it creates a new Node (pass DATA as the Node constructor argument)
 * and inserts it at the tail of the linked list referenced by the HEAD parameter. Once the new node is added, return the reference to the HEAD node.
 *
 * Note: If the HEAD argument passed to the insert function is null, then the initial list is empty.
 *
 * Input Format
 *
 * The insert function has 2 parameters: a pointer to a Node named HEAD, and an integer value, DATA.
 * The constructor for Node has 1 parameter: an integer value for the DATA field.
 *
 * Output Format
 * Your insert function should return a reference to the HEAD node of the linked list.
 *
 * Sample Input
 *
 * The following input is handled for you by the locked code in the editor:
 * The first line contains T, the number of test cases.
 * The T subsequent lines of test cases each contain an integer to be inserted at the list's tail.
 *
 * 4
 * 2
 * 3
 * 4
 * 1
 * Sample Output
 *
 * The locked code in your editor prints the ordered data values for each element in your list as a single line of space-separated integers:
 *
 * 2 3 4 1
 */
public class LinkedListNodes {

	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node insert(Node head,int data) {
		if(head == null)
			return new Node(data);
		else if(head.next == null){
			head.next = new Node(data);
		} else{
			insert(head.next,data);
		}
		return head;
		//Complete this method
	}

	public static void display(Node head) {
		Node start = head;
		while(start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while(N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head,ele);
		}
		display(head);
		sc.close();
	}
}
