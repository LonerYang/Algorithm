package linkedlist_06.linkedlist;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 循环链表
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-29 20:14:37
 */
public class CycleLinkedList<T> {

	private Node<T> head;

	private Node<T> tail;

	private int size;

	public void add(T t) {
		add(t, size);
	}

	public void add(T t, int index) {
		if (Objects.isNull(t)) {
			return;
		}
		checkIndexForAdd(index);
		Node<T> newNode = new Node<>(t);
		// 处理链表中还是为空的情况
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> pre = getNode(index - 1);
			newNode.next = pre.next;
			pre.next = newNode;
			// 处理在链表尾部添加节点的情况
			if (index == size) {
				tail = newNode;
			}
		}
		// 每次添加完更新tail.next 指向头结点
		tail.next = head;
		++size;
	}

	private Node<T> getNode(int index) {
		checkIndex(index);
		Node<T> temp = head;
		while(index != 0) {
			temp = temp.next;
			--index;
		}
		return temp;
	}

	private T get(int index) {
		return getNode(index).data;
	}

	private void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Require index >=0 and index <= size.");
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Require index >=0 and index < size.");
		}
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("->");
		Node<T> temp = head;
		while (true) {
			joiner.add(temp.data.toString());
			if (Objects.equals(temp, tail)) {
				break;
			}
			temp = temp.next;
		}
		return joiner.toString();
	}


	public static void main(String[] args) {
		CycleLinkedList<Integer> list = new CycleLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		System.out.println(list.tail.data);
		System.out.println(list.tail.next.data);
	}
}
