package stack_08;

import linkedlist_06.Node;

/**
 * 链表实现的链式栈
 * @author Yang
 * @version 1.0
 * @time 2019/10/27
 */
public class LinkedListStack {

	/**
	 * 定义头节点
	 */
	private Node<String> head;

	/**
	 * 定义尾节点
	 */
	private Node<String> last;

	/**
	 * 最后一个节点的上一个节点
	 */
	private Node<String> preLast;

	/**
	 * 栈中元素的个数
	 */
	private int count;

	public LinkedListStack() {
		count = 0;
		last = new Node<>();
		head = new Node<>();
	}

	/**
	 * 入栈
	 * @param element
	 * @return
	 */
	public boolean push(String element) {
		Node<String> node = new Node<>(element);
		if (count == 0) {
			head = node;
		}
		last.setNext(node);
		last = node;
		count++;
		return true;
	}

	/**
	 * 弹栈
	 * @return
	 */
	public String pop() {
		Node<String> temp = head;
		// 拿到倒数第二个节点
		while(temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		String result = last.getElement();
		temp.setNext(null);
		last = temp;
		count--;
		return result;
	}

	@Override
	public String toString() {
		return "LinkedListStack{" +
				"head=" + head +
				'}';
	}

	public static void main(String[] args) {
		LinkedListStack stack = new LinkedListStack();
		for (int i = 0; i < 5; i++) {
			stack.push(i + "");
		}
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
