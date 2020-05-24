package array_05;

import java.util.Arrays;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 实现一个动态扩容的数组
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-20 20:27:51
 */
public class Array {

	private static final int DEFAULT_CAPACITY = 10;

	private static final int[] EMPTY_ELEMENTDATA = {};

	private int[] elements;

	private int size = 0;

	public Array(int capacity) {
		if (capacity > 0) {
			elements = new int[capacity];
		} else if (capacity == 0) {
			elements = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					capacity);
		}
	}

	public Array() {
		elements = new int[DEFAULT_CAPACITY];
	}

	public void add(int element) {
		dilatation();
		elements[size++] = element;
	}

	private void dilatation() {
		if (elements.length == size) {
			// 需要扩容
			int[] newArray = new int[elements.length / 2 + elements.length];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
		}
	}

	public String toString() {
		return Arrays.toString(elements);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Array array = new Array(5);
		for (int i = 0; i < 10; ++i) {
			array.add(i);
		}
		System.out.println(array);
		System.out.println(array.size());
	}
}
