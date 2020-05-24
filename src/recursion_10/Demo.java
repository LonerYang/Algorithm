package recursion_10;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/12/3
 */
public class Demo {

	/**
	 * n个台阶有多少种走法把它走完
	 * @param n
	 * @return
	 */
	public static int f(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return f(n - 1) + f(n - 2);
	}

	/**
	 * 求n!
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return factorial(n - 1) * n;
	}

	/**
	 * 实现一组数据集合的全排列
	 * @param nums
	 */
	public static void fullPermutation(int[] nums, int start, int end) {
		if (start == end) {
			for (int i = 0; i <= end; ++i) {
				System.out.print(nums[i]);
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= end; ++i) {
			// 交换相当于固定一个数
			swap(nums, start, i);
			// 再去求后面的排列
			fullPermutation(nums, start + 1, end);
			// 排列完成后交换回来
			swap(nums, start, i);
		}

	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
//		System.out.println(f(5));
//		System.out.println(factorial(10));
		int[] nums = {1, 2, 3, 4};
		fullPermutation(nums, 0, 3);
	}
}
