package dynamic_programming_41;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 回溯算法解决最短路径问题
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-31 19:39:37
 */
public class MinDist {

	private int minDist = Integer.MAX_VALUE;

	/*
	 * 存储路径 n x n
	 */
	private int[][] w = {
			{1, 3, 5, 9},
			{2, 1, 3, 4},
			{5, 2, 6, 7},
			{6, 8, 4, 3}
	};

	/**
	 * 路径的长度
	 */
	private int n = 4;

	/**
	 * @param i 行
	 * @param j 列
	 * @param dist 起点到目标的路径和
	 */
	private void minDistBT(int i, int j, int dist) {
		dist = dist + w[i][j];
		if (i == n - 1 && j == n - 1) {
			if (dist < minDist) {
				minDist = dist;
			}
			return;
		}
		// 往右走
		if (j < n - 1) {
			minDistBT(i, j + 1, dist);
		}
		// 往下走
		if (i < n - 1) {
			minDistBT(i + 1, j, dist);
		}
	}

	private int minDistDP() {
		int[][] state = new int[n][n];
		int sum = 0;
		// 初始化第一行的数据
		for (int i = 0; i < n; ++i) {
			sum += w[0][i];
			state[0][i] = sum;
		}
		sum = 0;
		// 初始化第一列的数据
		for (int i = 0; i < n; ++i) {
			sum += w[i][0];
			state[i][0] = sum;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < n; ++j) {
				state[i][j] = w[i][j] + Math.min(state[i - 1][j], state[i][j - 1]);
			}
		}
		return state[n - 1][n - 1];
	}



	public static void main(String[] args) {
		MinDist demo01 = new MinDist();
		System.out.println(demo01.minDistDP());
	}
}
