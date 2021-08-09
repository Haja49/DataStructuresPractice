package week4;

import org.junit.Test;

public class ReverseLinkedList {

	public class Node {

		int value;
		Node next;

		Node(int key) {
			this.value = key;
			next = null;
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

	// reverse the node
	public Node reverseNode(Node node) {
		Node prev = null, next;
		while (node != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		return prev;
	}
	public Node reverseNodeUsingRecursion(Node node) {
		if (node == null || node.next == null) return node;
	    Node out = reverseNodeUsingRecursion(node.next);
	    node.next.next = node;
	    node.next = null;
	    return out;
	}

	@Test
	public void test1() {
		Node head = addNode(10);
		head.next = addNode(14);
		head.next.next = addNode(6);
		head.next.next.next = addNode(23);

		Node reverseNode = reverseNode(head);
		printAllNodes(reverseNode);

	}

}
