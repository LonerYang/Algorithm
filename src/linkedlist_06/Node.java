package linkedlist_06;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/10/27
 */
public class Node<T> {
	// 节点存储的信息
	private T element;

	// 下一个节点
	private Node<T> next;

	public Node() {
		this.next = null;
	}

	public Node(T element) {
		this.element = element;
		this.next = null;
	}

	public Node(T element, Node<T> next) {
		this.element = element;
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node{" +
				"element=" + element +
				", next=" + next +
				'}';
	}
}
