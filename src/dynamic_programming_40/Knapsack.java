package dynamic_programming_40;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-28 15:55:17
 */
public class Knapsack {

	public int knapsack2(int[] weight, int w) {
		boolean[] status = new boolean[w + 1];
		status[0] = true;
		if (weight[0] <= w) {
			status[weight[0]] = true;
		}
		for (int i = 1; i < weight.length; ++i) {
			// 如果升序遍历的话会出现重复计算的问题
			// 比如 j = 0，status[0]为true，weight[1]=2，则status[j + weight[i]]=status[2]=true，然后等到j=2的时候，status[2]也为true，而此时status[2]的值是刚算出来的。
			// 倒序就不会有上述问题
			for (int j = w - weight[i]; j >= 0; --j) {
				// 把第i个物品放入背包
				if (status[j]) {
					status[j + weight[i]] = true;
				}
			}
		}
		for (int i = w; i >= 0; --i) {
			if (status[i]) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * @param weight 每个物品的重量
	 * @param w 背包最大可承受重量
	 * @return
	 */
	public int knapsack(int[] weight, int w) {
		// 记录状态：是否操作过
		boolean[][] status = new boolean[weight.length][w + 1];
		// 初始化第一个物品
		status[0][0] = true;
		if (weight[0] <= w) {
			status[0][weight[0]] = true;
		}

		// i是物品的个数
		for (int i = 1; i < weight.length; ++i) {
			// j是背包的重量
			for (int j = 0; j <= w; ++j) {
				// 当前物品不放进背包
				if (status[i - 1][j]) {
					status[i][j] = status[i - 1][j];
				}
			}
			for (int j = 0; j <= w - weight[i]; ++j) {
				// 当前物品放进背包
				if (status[i - 1][j]) {
					status[i][j + weight[i]] = true;
				}
			}
		}

		for (int i = w; i >= 0; --i) {
			if (status[weight.length - 1][i]) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] items = {25, 10, 7, 8, 18, 20, 50, 19, 22, 17, 12, 29};
		Knapsack packsack = new Knapsack();
		System.out.println(packsack.knapsack(items, 100));
	}
}
