package week3;

import org.junit.Test;

public class OddEvenLinkedList {

	/*
	 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

		The first node is considered odd, and the second node is even, and so on.

		Note that the relative order inside both the even and odd groups should remain as it was in the input.

		You must solve the problem in O(1) extra space complexity and O(n) time complexity.
	 *
	 * Input = Node
	 * Output = Node
	 *
	 */

	public class Node {
		int value;
		Node next;

		Node() {
		}

		Node(int val) {
			this.value = val;
			this.next = null;
		}

	}

	public Node addNode(int key) {
		return new Node(key);
	}

	public void printAllNodes(Node node) {
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	/*
	 * 1. If head is null, return null.
	 * 2. Initialize odd node as head, even as head.next, evenHead equal to even
	 * 3. While even and even.next is not null
	 * 4. Replace odd.next with even.next and move the odd trav to next
	 * 5. Similarly replace even.next with odd.next and move the even trav to next
	 * 6. now add the evenHead after the odd head
	 * 7. Finally return head
	 */
	public Node oddEvenList(Node head) {
		if (head == null)
			return null;
		Node odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	@Test
	public void test1() {
		Node head = addNode(1);
		head.next = addNode(2);
		head.next.next = addNode(3);
		head.next.next.next = addNode(4);
		head.next.next.next.next = addNode(5);
		printAllNodes(oddEvenList(head));
	}

	@Test
	public void test2() {
		Node head = addNode(2);
		head.next = addNode(1);
		head.next.next = addNode(3);
		head.next.next.next = addNode(5);
		head.next.next.next.next = addNode(6);
		head.next.next.next.next.next = addNode(4);
		head.next.next.next.next.next.next = addNode(7);
		printAllNodes(oddEvenList(head));
	}
}
