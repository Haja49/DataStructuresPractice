package week6;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class RemoveLinkedListElements {

	/*
	 * Given the head of a linked list and an integer val, remove all the nodes of
	 * the linked list that has Node.val == val, and return the new head.
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
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	private Node removeElements(Node head, int val) {
		if (head == null)
			return null;
		Node output = new Node();
		Node temp = output;
		while (head != null) {
			if (head.value != val) {
				temp.next = head;
				temp = temp.next;
			} else {
				temp.next = null;
			}
			head = head.next;
		}
		return output.next;
	}

	private Node removeElementsUsingRecursion(Node head, int val) {
		if (head == null)
			return null;
		if (head.value == val)
			head =  removeElementsUsingRecursion(head.next, val);
		else {
			head.next = removeElementsUsingRecursion(head.next, val);
		}
		return head;
	}

	@Test
	public void test1() {
		Node head = addNode(1);
		head.next = addNode(2);
		head.next.next = addNode(6);
		head.next.next.next = addNode(3);
		head.next.next.next.next = addNode(4);
		head.next.next.next.next.next = addNode(5);
		head.next.next.next.next.next.next = addNode(6);
		printAllNodes(removeElementsUsingRecursion(head, 6));
	}

	@Test
	public void test2() {
		Node head = addNode(7);
		head.next = addNode(7);
		head.next.next = addNode(7);
		printAllNodes(removeElementsUsingRecursion(head, 7));
	}
}
