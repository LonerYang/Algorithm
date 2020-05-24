package array_05;

import java.util.Arrays;
import java.util.Objects;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 实现两个有序数组合并为一个有序数组
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-28 19:33:56
 */
public class MergeArray {

	private static int[] merge(int[] nums1, int[] nums2) {
		if (Objects.isNull(nums1)) {
			return nums2;
		}
		if (Objects.isNull(nums2)) {
			return nums1;
		}
		int[] result = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i != nums1.length && j != nums2.length) {
			if (nums1[i] > nums2[j]) {
				result[k++] = nums2[j++];
			} else {
				// 保持稳定性，如果等于的情况下先设置nums1的元素
				result[k++] = nums1[i++];
			}
		}
		if (i == nums1.length) {
			// nums1数组的元素设置完了
//			for (int n = k; n < result.length; ++n) {
//				result[n] = nums2[j++];
//			}
			for (; j < nums2.length; j++) {
				result[k++] = nums2[j];
			}
		} else {
			// nums2数组的元素设置完了
//			for (int n = k; n < result.length; ++n) {
//				result[n] = nums1[i++];
//			}
			for (; i < nums1.length; i++) {
				result[k++] = nums1[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 4, 7, 8};
		int[] nums2 = {2, 3, 5, 6, 9, 10, 12};
		int[] result = merge(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
}
