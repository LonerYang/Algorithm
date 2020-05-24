package dynamic_programming_40;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-28 18:51:36
 */
public class Knapsack2 {

	/**
	 * @param weight 每个物品的重量
	 * @param n 物品数量
	 * @param w 背包最大可承受重量
	 * @param values 每个物品的价值
	 * @return
	 */
	public int knapsack(int[] weight, int n, int[] values, int w) {
		int[][] status = new int[n][w + 1];
		// 初始化status
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < w + 1; ++j) {
				status[i][j] = -1;
			}
		}
		// 设置第一个物品的值
		status[0][0] = 0;
		if (weight[0] <= w) {
			status[0][weight[0]] = values[0];
		}
		for (int i = 1; i < n; ++i) {
			// 不放进去
			for (int j = 0; j <= w; ++j) {
				if (status[i - 1][j] >= 0) {
					status[i][j] = status[i - 1][j];
				}
			}
			// 放进去
			for (int j = 0; j <= w - weight[i]; ++j) {
				if (status[i - 1][j] > 0){
					// 加上这次物品的价值
					int v = status[i - 1][j] + values[i];
					if (v > status[i][j + weight[i]]) {
						status[i][j + weight[i]] = v;
					}
				}
			}
		}
		// 计算出最大值
		int maxValue = -1;
		for (int i = 0; i <= w; ++i) {
			if (status[n - 1][i] > maxValue) {
				maxValue = status[n - 1][i];
			}
		}
		return maxValue;
	}

}
