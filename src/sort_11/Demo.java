package sort_11;

import java.util.Arrays;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/12/6
 */
public class Demo {

	public static void bubbleSort(int[] nums, int length) {
		if (length <= 1) {
			return;
		}
		for (int i = 0; i < length; ++i) {
			// 决定是否继续循环的标识
			boolean flag = false;
			// 每次循环都把最大的元素移到数组的最后一位
			for (int j = 0; j < length - i - 1; ++j) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				// 如果没有交换就退出循环，说明前面的都比后面的小
				break;
			}
		}
	}

	public static void insertSort(int[] nums, int length) {
		if (length <= 1) {
			return;
		}
		for (int i = 1; i < length; i++) {
			// 未排序区间的首元素
			int value = nums[i];
			// 已排序区间末尾元素下标
			int j = i - 1;
			for (; j >= 0; j--) {
				if (nums[j] > value) {
					// 往后移动 一位
					nums[j + 1] = nums[j];
				} else {
					break;
				}
			}
			nums[j + 1] = value;
		}
	}

	public static void selectSort(int[] nums, int length) {
		if (length <= 1) {
			return;
		}
		for (int i = 0; i < length - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < length; ++j) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 6, 5};
//		bubbleSort(nums, 5);
//		insertSort(nums, 5);
		selectSort(nums, 5);
		System.out.println(Arrays.toString(nums));
	}
}
