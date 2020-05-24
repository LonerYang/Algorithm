package binary_search_16;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-20 19:25:46
 */
public class Demo {

	// 查找第一个值等于给定值的元素
	private static int binarySearch01(int[] nums, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] < value) {
				low = mid + 1;
			} else if (nums[mid] > value) {
				high = mid - 1;
			} else {
				if (mid == 0 || nums[mid - 1] != value) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	// 查找最后一个值等于给定值的元素
	private static int binarySearch02(int[] nums, int n, int value) {
		int low = 0;
		int high = n - 1;
		while(low <= high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] < value) {
				low = mid + 1;
			} else if (nums[mid] > value) {
				high = mid - 1;
			} else {
				if (mid == n -1 || nums[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	// 查找第一个大于等于给定值的元素
	private static int binarySearch03(int[] nums, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] >= value) {
				if (mid == 0 || nums[mid - 1] < value) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	// 查找最后一个小于等于给定值的元素
	private static int binarySearch04(int[] nums, int n, int value) {
		int low = 0;
		int high = n - 1;
		while(low <= high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] <= value) {
				if (mid == n - 1 || nums[mid + 1] > value) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 4, 6, 6, 6, 7, 8};
		System.out.println(binarySearch01(nums, 10, 6));
		System.out.println(binarySearch02(nums, 10, 6));
		System.out.println(binarySearch03(nums, 10, 5));
		System.out.println(binarySearch04(nums, 10, 5));
	}
}
