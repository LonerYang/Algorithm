package linkedlist_07;

import linkedlist_06.Node;
import org.junit.Test;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/10/27
 */
public class LinkedListCodeTest {

	private LinkedListCode<String> linkedListCode = new LinkedListCode<>();

	@Test
	public void testReverse() {
		Node<String> n4 = new Node<>("d");
		Node<String> n5 = new Node<>("c", n4);
		Node<String> n6 = new Node<>("b", n5);
		Node<String> n7 = new Node<>("a", n6);
		Node<String> node = linkedListCode.reverse(n7);
		System.out.println(node.getElement() + "->" + node.getNext().getElement() + "->" + node.getNext().getNext().getElement()
				+ "->" + node.getNext().getNext().getNext().getElement());
	}

	@Test
	public void testIsLoop() {

		Node<String> n1 = new Node<>("g");
		Node<String> n2 = new Node<>("f", n1);
		Node<String> n3 = new Node<>("e", n2);
		Node<String> n4 = new Node<>("d", n3);
		Node<String> n5 = new Node<>("c", n4);
		Node<String> n6 = new Node<>("b", n5);
		Node<String> n7 = new Node<>("a", n6);
		n1.setNext(n6);
		// 链表中环的检测
		System.out.println(linkedListCode.isLoop01(n7));
	}

	@Test
	public void testIsPalindrome() {
		Node<String> n4 = new Node<>("a");
		Node<String> n5 = new Node<>("b", n4);
		Node<String> n6 = new Node<>("b", n5);
		Node<String> n7 = new Node<>("a", n6);
		System.out.println(linkedListCode.isPalindrome(n7));
	}

	@Test
	public void testMergeTwoLinkedList() {
		Node<Integer> n5 = new Node<>(5);
		Node<Integer> n6 = new Node<>(2, n5);
		Node<Integer> n7 = new Node<>(1, n6);

		Node<Integer> n1 = new Node<>(7);
		Node<Integer> n2 = new Node<>(5, n1);
		Node<Integer> n3 = new Node<>(2, n2);
		Node<Integer> n4 = new Node<>(1, n3);

		Node<Integer> head = linkedListCode.mergeTwoLinkedList(n7, n4);
		System.out.println(head.getElement() + "->" + head.getNext().getElement() + "->" + head.getNext().getNext().
				getElement() + "->" + head.getNext().getNext().getNext().getElement() + "->" + head.getNext().getNext().
				getNext().getNext().getElement() + "->" + head.getNext().getNext().getNext().getNext().getNext().getElement()
				+ "->" + head.getNext().getNext().getNext().getNext().getNext().getNext().getElement());
	}

	@Test
	public void testRemoveLastN() {
		Node<String> n1 = new Node<>("4");
		Node<String> n2 = new Node<>("3", n1);
		Node<String> n3 = new Node<>("2", n2);
		Node<String> n4 = new Node<>("1", n3);
		Node<String> result = linkedListCode.removeLastN(n4, 2);
		System.out.println(result.getElement() + "->" + result.getNext().getElement() + "->" + result.getNext().getNext().getElement());
	}

	@Test
	public void testMidNode() {
		Node<String> n1 = new Node<>("5");
		Node<String> n2 = new Node<>("4", n1);
		Node<String> n3 = new Node<>("3", n2);
		Node<String> n4 = new Node<>("2", n3);
		Node<String> n5 = new Node<>("1", n4);

		System.out.println(linkedListCode.midNode(n5));
	}
}
