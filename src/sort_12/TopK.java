package sort_12;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-05-24 08:36:54
 */
public class TopK {

	private static int getTopK(int[] nums, int p, int r, int topK) {
		int q = partition(nums, p, r);
		if (topK > q + 1) {
			return getTopK(nums, q + 1, r, topK);
		}
		if (topK < q + 1) {
			return getTopK(nums, p, q - 1, topK);
		}
		if (topK == q + 1){
			return nums[q];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 6, 5};
		int topK = getTopK(nums, 0, 4, 4);
		System.out.println(topK);
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
				Demo.swap(nums, i, j);
				i++;
			}
		}
		Demo.swap(nums, i, r);
		return i;
	}

}
