package sort_12;

import java.util.Arrays;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2019-12-17 09:21:30
 */
public class Demo {

	/**
	 * 归并排序算法
	 * @param nums 要排序的数组
	 * @param p,r 给下标p到r的数组进行排序
	 */
	public static void mergeSort(int[] nums, int p, int r) {
		// 递归终止条件
		if (p >= r) {
			return;
		}
		// 取p到r的中间位置q
		int q = (p + r) / 2;
		// 分支递归
		mergeSort(nums, p, q);
		mergeSort(nums, q + 1, r);
		// 将nums[p...q]和nums[q + 1...r]合并为nums[p...r]
		merge(nums, p, r, q);
	}

	/**
	 *  接受两个有序数组nums[p...q], nums[q+1...r]合并后拷贝到nums[p...r]
	 * @param nums
	 * @param p
	 * @param r
	 * @param q
	 */
	private static void merge(int[] nums, int p, int r, int q) {
		// k：temp的数组最后一个元素的下标
		int i = p, j = q + 1, k = 0;
		// 申请一个大小跟nums[p...r]一样大的数组
		int[] temp = new int[r - p + 1];
		while(i <= q && j <= r) {
			if (nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		// 判断哪个子数组中还有数据
		int start = i, end = q;
		if (j <= r) {
			start = j;
			end = r;
		}
		// 将剩余的数据拷贝到临时数组
		while(start <= end) {
			temp[k++] = nums[start++];
		}
		// 将temp中的数据拷贝回nums[p...r]
		for (int a = 0; a <= temp.length; a++) {
			nums[p + a] = temp[a];
		}
	}

	/**
	 * 快速排序，给下标p到r的数组排序
	 * @param nums
	 * @param p
	 * @param r
	 */
	public static void quickSort(int[] nums, int p, int r) {
		if (p >= r) {
			return;
		}
		// 对nums[p...r]进行分区，函数返回pivot(分区点)的下标
		int q = partition(nums, p, r);
		quickSort(nums, p, q - 1);
		quickSort(nums, q + 1, r);
	}

	/**
	 * 获取分区点
	 * @param nums
	 * @param p
	 * @param r
	 * @return
	 */
	private static int partition(int[] nums, int p, int r) {
		// p...j-1 为已处理区间，j..r-1 是未处理区间
		int pivot = nums[r];
		// p...i - 1 为小于pivot的区间
		// i用来保存大于pivot的元素的下标
		int i = p;
		for (int j = p; j < r; j++) {
			if (nums[j] < pivot) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, r);
		return i;
	}


	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 6, 5};
//		mergeSort(nums, 0, 4);
		quickSort(nums, 0, 4);
		System.out.println(Arrays.toString(nums));
	}
}
