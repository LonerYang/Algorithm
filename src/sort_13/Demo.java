package sort_13;

import java.util.Arrays;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-19 20:56:18
 */
public class Demo {

	/**
	 * 计数排序
	 * @param a
	 * @param n
	 */
	public static void CountingSort(int[] a, int n) {
		int max = a[0];
		for(int i = 1; i < n; ++i) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		// 申请一个计数数组（也有可能有0，所以+1）
		int[] c = new int[max + 1];
		for (int i = 0; i <= max; i++) {
			c[i] = 0;
		}
		// 数组a中每个元素的个数存储进数组c
		for (int i = 0; i < n; ++i) {
			c[a[i]]++;
		}
		// 对数组c进行顺序求和
		for (int i = 1; i <= max; i++) {
			c[i] += c[i - 1];
		}
		// 临时数组r，用来存储排序之后的结果
		int[] r = new int[n];
		// 从尾开始遍历数组a（如果从头开始遍历就不是稳定的排序算法了）
		for (int i = n - 1; i >= 0; i--) {
			// 算出数组a中某个元素在排序数组中的下标
			int index = c[a[i]] - 1;
			r[index] = a[i];
			c[a[i]]--;
		}
		// 拷贝回原数组
		System.arraycopy(r, 0, a, 0, n);
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 6, 5};
		CountingSort(nums, 5);
		System.out.println(Arrays.toString(nums));
	}
}
