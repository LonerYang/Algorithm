package binary_tree_23;

import java.util.Objects;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 二叉树的三种遍历（前、中、后序遍历）
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-23 11:20:29
 */
public class Demo {

	/**
	 * 二叉树前序遍历
	 * @param root 二叉树的根节点
	 */
	private void preOrder(Node root) {
		if (Objects.isNull(root)) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * 二叉树中序遍历
	 * @param root 二叉树的根节点
	 */
	private void inOrder(Node root) {
		if (Objects.isNull(root)) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	/**
	 * 二叉树后序遍历
	 * @param root
	 */
	private void postOrder(Node root) {
		if (Objects.isNull(root)) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}



	public static void main(String[] args) {
		Node<String> root = new Node<>("A");

		Node<String> n1 = new Node<>("B");
		Node<String> n2= new Node<>("C");
		Node<String> n3 = new Node<>("D");
		Node<String> n4 = new Node<>("E");
		Node<String> n5 = new Node<>("F");
		Node<String> n6 = new Node<>("G");

		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		root.left = n1;
		root.right = n2;

		new Demo().preOrder(root);
		System.out.println();
		new Demo().inOrder(root);
		System.out.println();
		new Demo().postOrder(root);
		System.out.println();
	}
}