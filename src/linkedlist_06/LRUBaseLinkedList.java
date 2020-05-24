package linkedlist_06;

import java.util.Objects;

/**
 * 基于单链表实现LRU算法
 * 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 	  a.如果此时缓存未满，则将此结点直接插入到链表的头部；
 *    b.如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 * @author Yang
 * @version 1.0
 * @time 2019/10/25
 */
public class LRUBaseLinkedList<T> {
	// 链表的容量
	private int capacity = 10;

	// 哨兵节点
	public Node<T> head;

	// 链表长度
	private int length;

	public LRUBaseLinkedList() {
		// 初始化哨兵节点
		head = new Node();
		length = 0;
	}

	/**
	 * 添加新节点
	 */
	public void add(T element) {
		Node<T> preNode = findPreNode(element);
		// 链表中存在，删除原节点，添加到头部
		if (preNode != null) {
			deleteNode(preNode);
			insertHead(element);
		} else {
			if (length >= capacity) {
				deleteNodeOfEnd();
			}
			insertHead(element);
		}
	}

	/**
	 * 删除尾部节点
	 */
	private void deleteNodeOfEnd() {
		Node<T> temp = head;
		// 拿到倒数第二个节点
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		Node<T> lastNode = temp.getNext();
		temp.setNext(null);
		lastNode = null;
		length--;
	}

	/**
	 * 把节点插入到头部
	 * @param element
	 */
	private void insertHead(T element) {
		Node<T> next = head.getNext();
		head.setNext(new Node<T>(element, next));
		length++;
	}

	/**
	 * 删除preNode的下一个节点
	 * @param preNode 当前节点的上一个节点
	 */
	private void deleteNode(Node<T> preNode) {
		Node<T> currentNode = preNode.getNext();
		preNode.setNext(currentNode.getNext());
		currentNode = null;
	}

	/**
	 * 根据数据找到对应的节点
	 */
	private Node<T> findPreNode(T element) {
		Node<T> temp = head;
		while (temp.getNext() != null) {
			if (Objects.equals(temp.getNext().getElement(), element)) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<T> temp = head.getNext();
		while (temp.getNext() != null) {
			sb.append(temp.getElement() + ",");
			temp = temp.getNext();
		}
		sb.append(temp.getElement() + "]");
		return sb.toString();
	}

	public static void main(String[] args) {
		LRUBaseLinkedList<Integer> linkedList = new LRUBaseLinkedList<>();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		System.out.println(linkedList);
		linkedList.add(20);
		System.out.println(linkedList);
		linkedList.add(5);
		System.out.println(linkedList);
	}
}
