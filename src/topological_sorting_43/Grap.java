package topological_sorting_43;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-06 16:45:44
 */
public class Grap {

	/**
	 * 顶点的个数
	 */
	private int v;

	/**
	 * 邻接表
	 */
	private LinkedList<Integer>[] adj;

	public Grap(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	/**
	 * s -> t
	 * @param s
	 * @param t
	 */
	public void addEdge(int s, int t) {
		adj[s].add(t);
	}

	public void topoSortByKahn() {
		// 统计每个顶点的入度
		int[] inDegree = new int[v];
		for (int i = 0; i < v; ++i) {
			for (int j = 0; j < adj[i].size(); ++j) {
				Integer w = adj[i].get(j);
				inDegree[w]++;
			}
		}
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < v; ++i) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		List<String> result = new ArrayList<>(4);
		while(!queue.isEmpty()) {
			Integer i = queue.remove();
			result.add(i + "");
			// 删除入度为0的顶点：入度为0的顶点指向的顶点的入度都减1，
			for (int j = 0; j < adj[i].size(); ++j) {
				int k = adj[i].get(j);
				inDegree[k]--;
				if (inDegree[k] == 0) {
					queue.add(k);
				}
			}
		}
		System.out.println(String.join("->", result));
	}

	private void topoSortByDFS() {
		// 先构建逆邻表
		LinkedList<Integer>[] inverseAdj = new LinkedList[v];
		// 初始化逆邻表
		for (int i = 0; i < v; ++i) {
			inverseAdj[i] = new LinkedList<>();
		}
		// 通过邻接表构建逆邻表
		for (int i = 0; i < v; ++i) {
			for (int j = 0; j < adj[i].size(); ++j) {
				// i -> w转换成w -> i
				Integer w = adj[i].get(j);
				inverseAdj[w].add(i);
			}
		}
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, inverseAdj, visited);
			}
		}

	}

	private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
		for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
			Integer w = inverseAdj[vertex].get(i);
			if (visited[w]) {
				continue;
			}
			visited[w] = true;
			dfs(w, inverseAdj, visited);
		}
		// 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
		System.out.println("->" + vertex);
	}

	public static void main(String[] args) {
		// 0123代表ABCD
		Grap grap = new Grap(4);
		grap.addEdge(2, 1);
		grap.addEdge(1, 3);
		grap.addEdge(1, 0);
//		grap.topoSortByKahn();
		grap.topoSortByDFS();
	}

}
