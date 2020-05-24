package bfs_dfs_31;

import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 邻接表实现的无向图
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-02-08 20:38:03
 */
public class Graph {

	/**
	 * 深度优先搜索算法标识
	 */
	private boolean found;

	/**
	 * 顶点的个数
	 */
	private int v;

	/**
	 * 邻接表
	 */
	private LinkedList<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	/**
	 * 添加图的边
	 * @param s
	 * @param t
	 */
	public Graph addEdge(int s, int t) {
		// 无向图一条边存两次
		adj[s].add(t);
		adj[t].add(s);
		return this;
	}

	/**
	 * 广度优先搜索算法
	 * @param s
	 * @param t
	 */
	public void bfs(int s, int t) {
		if (s == t) {
			return;
		}
		// 用来记录已经被访问的顶点
		boolean[] visited = new boolean[v];
		visited[s] = true;
		// 用来存储已经被访问、但相连的顶点还没有被访问的顶点
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		// 用来记录搜索路径，路径是反向存储的，prev[w]存储的是，顶点 w 是从哪个前驱顶点遍历过来的。
		// 比如，我们通过顶点 2 的邻接表访问到顶点 3，那 prev[3]就等于 2。
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		while (queue.size() != 0) {
			// 根据w顶点找到下一层顶点
			int w = queue.poll();
			for (int i = 0; i < adj[w].size(); ++i) {
				int q = adj[w].get(i);
				if (!visited[q]) {
					prev[q] = w;
					// 找到了截止顶点
					if (q == t) {
						print(prev, s, t);
						return;
					}
					// 没有找到
					// 1.设置q顶点被访问过。
					// 2.将q节点加入queue中方便找到q节点的下一层节点。
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}

	// 递归打印s -> t的路径
	private void print(int[] prev, int s, int t) {
		if (prev[t] != -1 && t != s) {
			print(prev, s, prev[t]);
		}
		System.out.print(t + " ");
	}


	/**
	 * 深度优先搜索算法
	 * @param s
	 * @param t
	 */
	public void dfs(int s, int t) {
		found = false;
		boolean[] visited = new boolean[v];
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		recurDfs(s, t, visited, prev);
		print(prev, s, t);
	}

	private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		if (found == true) {
			return;
		}
		visited[w] = true;
		if (w == t) {
			found = true;
			return;
		}
		for (int i = 0; i < adj[w].size(); ++i) {
			// 避免找到截止顶点后还继续遍历
			if (found == true) {
				return;
			}
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				recurDfs(q, t, visited, prev);
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addEdge(0, 1).addEdge(0, 3).addEdge(1, 4).addEdge(1, 2).addEdge(2, 5)
				.addEdge(3, 4).addEdge(4, 5).addEdge(4, 6).addEdge(5, 7).addEdge(6, 7);
		graph.bfs(0, 6);
		System.out.println();
		graph.dfs(0, 6);
		System.out.println();
	}

}
