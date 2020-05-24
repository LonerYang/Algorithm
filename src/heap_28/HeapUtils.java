package heap_28;

import util.ArrayUtils;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 堆排序
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-31 10:44:47
 */
public class HeapUtils {

	public static void buildHeap(int[] a, int n) {
		for (int i = n / 2; i >= 1; --i) {
			heapify(a, n, i);
		}
	}

	// 自上而下堆化
	private static void heapify(int[] a, int n, int i) {
		while(true) {
			int maxPos = i;
			// 算出最大的位置
			if (i * 2 <= n && a[i * 2] > a[i]) {
				maxPos = i * 2;
			}
			if (i * 2 + 1 <= n && a[i * 2 + 1] > a[maxPos]) {
				maxPos = i * 2 + 1;
			}
			if (maxPos == i) {
				break;
			}
			ArrayUtils.swap(a, i, maxPos);
			i = maxPos;
		}
	}

	public static void sort(int[] a, int n) {
		buildHeap(a, n);
		int k = n;
		while(k > 1) {
			ArrayUtils.swap(a, 1, k);
			--k;
			heapify(a, k, 1);
		}
	}
}
