import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-11 12:07:43
 */
public class Demo {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (Objects.isNull(root)) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<>();
		// 用来存储每层的节点
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			// 存储每层的节点值
			List<Integer> childResult = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode w = queue.poll();
				childResult.add(w.val);
				if (Objects.nonNull(w.left)) {
					queue.add(w.left);
				}
				if (Objects.nonNull(w.right)) {
					queue.add(w.right);
				}
			}
			result.add(childResult);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);

		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n2.right = n4;
		System.out.println(levelOrder(root));

	}

	static class TreeNode {

		int val;

		TreeNode left;

		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

}
