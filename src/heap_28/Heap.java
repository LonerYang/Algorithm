package heap_28;

import util.ArrayUtils;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 大顶堆
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-01-31 09:38:56
 */
public class Heap {
	// 数组，从下标1开始存储数据
	private int[] a;

	// 堆可以存储的最大数据个数
	private int n;

	// 堆中已经存储的数据个数
	private int count;

	public Heap(int capacity) {
		a = new int[capacity + 1];
		n = capacity;
		count = 0;
	}

	/**
	 *  移除堆顶
	 */
	public void removeMax() {
		if (count == 0) {
			return;
		}
		a[1] = a[count];
		--count;
		heapify(a, count, 1);
	}

	public void insert(int data) {
		if (count >= n) {
			return;
		}
		++count;
		a[count] = data;
		int i = count;
		// 自下而上堆化
		while(i / 2 > 0 && a[i] > a[i / 2]) {
			ArrayUtils.swap(a, i, i / 2);
			i = i / 2;
		}
	}

	// 自上而下堆化
	private void heapify(int[] a, int count, int i) {
		while (true) {
			int maxPos = i;
			if (i * 2 <= n && a[i * 2] > a[i]) {
				maxPos = i * 2;
			}
			if (i * 2 + 1 <= n && a[i * 2 + 1] > a[maxPos]) {
				maxPos = i * 2 + 1;
			}
			if (maxPos == i) {
				break;
			}
			ArrayUtils.swap(a, maxPos, i);
			i = maxPos;
		}
	}
}
