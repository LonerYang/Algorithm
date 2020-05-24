package recursion_tree_27;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-26 10:26:17
 */
public class Demo {

	/**
	 * 打印一组数据的所有排列
	 * @param data 原始数组
	 * @param n 数组的长度
	 * @param k 表示要处理子数组的数据个数
	 */
	private static void printPermutations(int[] data, int n, int k) {
		if (k == 1) {
			for (int i = 0; i < n; ++i) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < k; ++i) {
			swap(data, i, k - 1);
			printPermutations(data, n, k - 1);
			swap(data, i, k - 1);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		printPermutations(nums, 3, 3);
	}
}
