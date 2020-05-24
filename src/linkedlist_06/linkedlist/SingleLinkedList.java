package linkedlist_06.linkedlist;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 单链表
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-28 20:31:17
 */
public class SingleLinkedList<T> {

	private Node<T> head;

	private int size = 0;

	public void add(T t) {
		add(t, size);
	}

	public void add(T t, int index) {
		checkIndexForAdd(index);
		if (Objects.isNull(t)) {
			return;
		}
		Node<T> node = new Node<>(t);
		if (index == 0) {
			node.next = head;
			head = node;
		} else {
			Node<T> pre = get(index - 1);
			node.next = pre.next;
			pre.next = node;
		}
		++size;
	}

	public Node<T> get(int index) {
		checkIndex(index);
		Node<T> temp = head;
		while(index != 0) {
			temp = temp.next;
			--index;
		}
		return temp;
	}

	public void remove(int index) {
		checkIndex(index);
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> pre = null;
			Node<T> temp = head;
			while (index != 0) {
				pre = temp;
				temp = temp.next;
				--index;
			}
			pre.next = temp.next;
		}
		--size;
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

	public void setHead(Node<T> head) {
		this.head = head;
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


	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);

		list.add(100, 1);
		System.out.println(list);

		list.add(0, 0);
		System.out.println(list);
	}
}
