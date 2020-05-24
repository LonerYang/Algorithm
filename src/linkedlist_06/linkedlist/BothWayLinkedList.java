package linkedlist_06.linkedlist;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-05-03 12:45:35
 */
public class BothWayLinkedList<T> {

	private Node<T> head;

	private int size;

	public void add(T t) {
		add(t, size);
	}

	public void add(T t, int index) {
		checkIndexForAdd(index);
		if (Objects.isNull(t)) {
			return;
		}
		Node<T> newNode = new Node<>(t);
		if (head == null) {
			head = newNode;
			++size;
			return;
		}
		if (index == size) {
			Node<T> pre = getNode(index - 1);
			pre.next = newNode;
			newNode.pre = pre;
			++size;
			return;
		}
		if (index == 0) {
			newNode.next = head;
			head.pre = newNode;
			head = newNode;
		} else {
			Node<T> pre = getNode(index - 1);
			Node<T> next = pre.next;

			newNode.next = next;
			next.pre = newNode;
			pre.next = newNode;
			newNode.pre = pre;
		}
		++size;
	}

	private Node<T> getNode(int index) {
		checkIndex(index);
		Node<T> temp = head;
		while (index != 0) {
			temp = temp.next;
			--index;
		}
		return temp;
	}

	public T get(int index) {
		checkIndex(index);
		return getNode(index).data;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Require index >=0 and index < size.");
		}
	}

	private void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Require index >=0 and index <= size.");
		}
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("->");
		Node<T> temp = head;
		while (temp != null) {
			joiner.add(temp.data.toString());
			temp = temp.next;
		}
		return joiner.toString();
	}

	class Node<T> {
		T data;

		Node<T> next;

		Node<T> pre;

		Node(T data) {
			this.data = data;
		}

		Node() {
		}
	}

	public static void main(String[] args) {
		BothWayLinkedList<Integer> list = new BothWayLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		System.out.println(list.getNode(2).pre.data);
	}
}
