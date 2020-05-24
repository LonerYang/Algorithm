package binary_search_15;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-20 19:25:46
 */
public class Demo {

	private static int binarySearch(int[] nums, int n, int value) {
		int high = n - 1;
		int low = 0;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] == value) {
				return mid;
			} else if (nums[mid] > value) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private static int binarySearch02(int[] nums, int n, int value) {
		return bsearchInternally(nums, 0, n - 1, value);
	}

	private static int bsearchInternally(int[] nums, int low, int high, int value) {
		if (low > high) {
			return -1;
		}
		int mid = low + ((high - low) >> 1);
		if (nums[mid] == value) {
			return mid;
		} else if (nums[mid] > value) {
			return bsearchInternally(nums, low, mid - 1, value);
		} else {
			return bsearchInternally(nums, mid + 1, high, value);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(binarySearch(nums, 8, 3));
		binarySearch02(nums, 8, 3);
	}
}
