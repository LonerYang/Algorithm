package binary_tree_23;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-23 11:28:04
 */
public class Node<T> {
	public T data;

	public Node<T> left;

	public Node<T> right;

	public Node(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node{" +
				"data=" + data +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
