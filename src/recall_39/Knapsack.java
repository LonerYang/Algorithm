package recall_39;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 0-1背包问题
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-24 14:12:42
 */
public class Knapsack {

	/**
	 * 存储每次放法的总重量
	 * 取最大的一个
	 */
	private int maxW = 0;

	/**
	 * 可以挑选的物品
	 */
	private int[] items;

	/**
	 * 背包最大可承受重量
	 */
	private int w;

	/**
	 * @param i 表示考察到哪个物品了
	 * @param cw 表示当前已经装进去的物品的重量和
	 */
	private void f(int i, int cw) {
		// cw == w 当前已经装进去的物品的重量和等于背包最大可承受重量
		// i == items.length 考察到最后一个物品了
		if (cw == w || i == items.length) {
			if (cw > maxW) {
				// 每次把重量大的赋值给maxW
				maxW = cw;
			}
			return;
		}
		// 不装当前选择的物品
		f(i + 1, cw);
		// 加上当前选择的物品重量没有超过背包最大可承受重量的话，将当前选择的物品加入到背包中
		if (cw + items[i] <= w) {
			// 装当前选择的物品
			f(i + 1, cw + items[i]);
		}
	}

	public static void main(String[] args) {
		int[] items = {25, 10, 7, 8, 18, 20, 50, 19, 22, 17, 12, 29};
		Knapsack packsack = new Knapsack();
		packsack.items = items;
		packsack.w = 100;
		packsack.f(0, 0);
		System.out.println(packsack.maxW);
	}


}
