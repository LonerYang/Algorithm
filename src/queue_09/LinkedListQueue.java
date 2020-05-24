package queue_09;

import linkedlist_06.Node;

/**
 * 基于链表实现的队列
 * @author Yang
 * @version 1.0
 * @time 2019/10/28
 */
public class LinkedListQueue {

	Node<String> head = null;
	Node<String> tail = null;

	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		Node<String> newNode = new Node<>(item);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		return true;
	}

	/**
	 * 出队
	 * @return
	 */
	public String dequeue() {
		if (head == null) {
			return null;
		}
		String result = head.getElement();
		head = head.getNext();
		if (head == null) {
			tail = null;
		}
		return result;
	}

	@Override
	public String toString() {
		return "LinkedListQueue{" +
				"head=" + head +
				'}';
	}

	public static void main(String[] args) {
		LinkedListQueue queue = new LinkedListQueue();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i + "");
		}
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
	}
}
