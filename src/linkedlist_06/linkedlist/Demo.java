package linkedlist_06.linkedlist;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-05-03 14:10:02
 */
public class Demo<T> {

	/**
	 * 单链表反转
	 * @param list
	 */
	public void reverse(SingleLinkedList<T> list) {
		Node<T> node = list.get(0);
		Node<T> pre = null;
		while (node != null) {
			final Node<T> nextNode = node.next;
			node.next = pre;
			pre = node;
			node = nextNode;
		}
		list.setHead(pre);
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		new Demo<Integer>().reverse(list);
		System.out.println(list);
	}
}
