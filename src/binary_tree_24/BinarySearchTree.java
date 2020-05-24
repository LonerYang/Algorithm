package binary_tree_24;

import binary_tree_23.Node;

import java.util.Objects;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 二叉查找树的查找、插入、删除操作
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-23 18:39:13
 */
public class BinarySearchTree<T> {

	private Node<T> tree;

	public BinarySearchTree(Node<T> tree) {
		this.tree = tree;
	}

	/**
	 * 二叉查找树的查找
	 *
	 * @param data 要查的数据
	 * @return 返回数据对于的节点
	 */
	private Node find(int data) {
		Node<Integer> p = (Node<Integer>) tree;
		while (Objects.nonNull(p)) {
			if (data > p.data) {
				p = p.right;
			} else if (data < p.data) {
				p = p.left;
			} else {
				return p;
			}
		}
		return null;
	}

	private void insert(int data) {
		if (Objects.isNull(tree)) {
			tree = (Node<T>) new Node<Integer>(data);
		}
		Node<Integer> p = (Node<Integer>) tree;

		while (Objects.nonNull(p)) {
			if (data < p.data) {
				if (Objects.isNull(p.left)) {
					p.left = new Node<Integer>(data);
					return;
				}
				p = p.left;
			} else {
				if (Objects.isNull(p.right)) {
					p.right = new Node<Integer>(data);
					return;
				}
				p = p.right;
			}
		}
	}

	private void delete(int data) {
		// 要删除的节点
		Node<Integer> p = (Node<Integer>) tree;
		// p节点的父节点
		Node pp = null;
		// 查找要删除的节点
		while (Objects.nonNull(p) && !Objects.equals(p.data, data)) {
			pp = p;
			if (data < p.data) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		if (Objects.isNull(p)) {
			// 没有找到
			return;
		}

		// 查找右子树中最小节点
		if (Objects.nonNull(p.left) && Objects.nonNull(p.right)) {
			// 右子树中的最小节点
			Node<Integer> minP = p.right;
			Node<Integer> minPP = p;
			// 最小的节点为左子树的叶子节点
			while(Objects.nonNull(minP.left)) {
				minPP = minP;
				minP = minP.left;
			}
			// 将右子树中最小节点的值替换到要删除的节点上
			p.data = minP.data;
			// 接下来就变成了要删除minP了
			p = minP;
			pp = minPP;
		}

		// 删除节点是叶子节点或者仅有一个节点
		// p的子节点
		Node<Integer> child;
		if (Objects.nonNull(p.left)) {
			child = p.left;
		} else if (Objects.nonNull(p.right)) {
			child = p.right;
		} else {
			child = null;
		}

		// 删除的是根节点（这种情况根节点下只有一个子节点或者没有子节点）
		if (Objects.isNull(pp)) {
			tree = (Node<T>) child;
		} else if (pp.left == p) {
			pp.left = child;
		} else {
			pp.right = child;
		}
	}

	private void inOrder(Node tree) {
		if (tree == null) {
			return;
		}
		inOrder(tree.left);
		System.out.print(tree.data + " ");
		inOrder(tree.right);
	}

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(50);
		Node<Integer> n1 = new Node<>(40);
		Node<Integer> n2 = new Node<>(55);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(45);
		Node<Integer> n5 = new Node<>(52);
		Node<Integer> n6 = new Node<>(60);

		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		root.left = n1;
		root.right = n2;

		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(root);
		System.out.println(binarySearchTree.find(40).left.data);

		binarySearchTree.insert(58);
		System.out.println(binarySearchTree.tree);

		binarySearchTree.inOrder(binarySearchTree.tree);
	}
}
