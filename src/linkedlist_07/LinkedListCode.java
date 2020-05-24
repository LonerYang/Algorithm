package linkedlist_07;

import linkedlist_06.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 链表的常用操作
 * 1、单链表反转
 * 2、单链表中环的检测
 * 3、单链表中存的是否为回文字符串
 * 4、两个有序链表合并
 * 5、删除链表第n个节点
 * @author Yang
 * @version 1.0
 * @time 2019/10/27
 */
public class LinkedListCode<T> {

	/**
	 * 单链表反转
	 */
	public Node<T> reverse(Node<T> node) {
		Node<T> prev = null;
		while(node != null) {
			Node<T> next = node.getNext();
			node.setNext(prev);
			prev = node;
			node = next;
		}
		return prev;
	}
	/**
	 * 快慢指针法
	 * @param node
	 * @return
	 */
	public boolean isLoop01(Node<T> node) {
		Node<T> fast = node;
		Node<T> slow = node;
		while(fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			// 如果快慢指针碰到了，链表中就有环
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 足迹法
	 * @param node
	 * @return
	 */
	public boolean isLoop02(Node<T> node) {
		Map<T, Integer> map = new HashMap<>();
		while(node.getNext() != null) {
			// 如果map中有这个节点的值就说明有环
			if (map.containsKey(node.getElement())) {
				return true;
			}
			// 否则把节点的值添加进去
			map.put(node.getElement(), 1);
			node = node.getNext();
		}
		// 循环结束后说明没有环
		return false;
	}

	/**
	 * 链表中存的是否为回文字符串
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(Node<T> head) {
		if (head == null || head.getNext() == null) {
			return true;
		}

		Node<T> prev = null;
		Node<T> slow = head;
		Node<T> fast = head;

		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			Node<T> next = slow.getNext();
			// 设置慢指针的下一个为上一个，反转一半链表
			slow.setNext(prev);
			prev = slow;
			slow = next;
		}

		if (fast != null) {
			// 如果快指针不等于null说明链表是奇数个，此时慢指针指向中间节点
			// 中间节点没有节点比较，所以让慢指针往前移一位
			slow = slow.getNext();
		}

		// slow 指向右半链表，prev执行左半链表
		while(slow != null) {
			if (!Objects.equals(prev.getElement(), slow.getElement())) {
				// 只要有一个相对的字符不一样就返回false
				return false;
			}
			// 相对方向移动
			prev = prev.getNext();
			slow = slow.getNext();
		}
		return true;
	}

	/**
	 * 合并两个有序链表
	 * @param l1
	 * @param l2
	 * @return
	 */
	public Node<Integer> mergeTwoLinkedList(Node<Integer> l1, Node<Integer> l2) {
		Node<Integer> head = new Node<>();
		// 将head引用赋值给p，用p来循环操作，head用作保存原来的引用地址
		Node<Integer> p = head;
		while(l1 != null && l2 != null) {
			if (l1.getElement() <= l2.getElement()) {
				p.setNext(l1);
				l1 = l1.getNext();
			} else {
				p.setNext(l2);
				l2 = l2.getNext();
			}
			p = p.getNext();
		}

		if (l1 != null) {
			p.setNext(l1);
		}
		if (l2 != null) {
			p.setNext(l2);
		}
		return head.getNext();
	}

	/**
	 * 删除链表中倒数第n个节点
	 * @param head
	 * @return
	 */
	public Node<T> removeLastN(Node<T> head, int n) {
		if (head == null || n <= 0) {
			return null;
		}
		Node<T> temp = new Node<>();
		temp.setNext(head);
		Node<T> preDelete = temp;
		for (int i = 0; i < n; i++) {
			head = head.getNext();
		}
		while (head != null) {
			head = head.getNext();
			preDelete = preDelete.getNext();
		}
		Node<T> delNode = preDelete.getNext();
		preDelete.setNext(delNode.getNext());
		delNode = null;
		return temp.getNext();
	}

	/**
	 * 求中间节点
	 * @param node
	 * @return
	 */
	public Node<T> midNode(Node<T> node) {
		Node<T> slow = node;
		Node<T> fast = node;

		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		// 如果快指针为null的话说明链表是偶数个节点，返回null;反之就是奇数个节点
		if (fast == null) {
			return null;
		} else {
			return slow;
		}
	}

}
