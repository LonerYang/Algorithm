package array_05;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 实现一个大小固定的有序数组，支持动态增删改操作
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-20 20:47:16
 */
public class MyArrayList<E> {

	private static final int DEFAULT_CAPACITY = 10;

	private Object[] elements;

	private static final Object[] EMPTY_ELEMENTDATA = {};

	private int size = 0;

	public MyArrayList(int capacity) {
		if (capacity > 0) {
			elements = new Object[capacity];
		} else if (capacity == 0) {
			elements = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					capacity);
		}
	}

	public MyArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(E e) {
		dilatation();
		elements[size++] = e;
	}

	public void add(int index, E e) {
		checkIndexForAdd(index);
		dilatation();
		// 这里size != length，所以不会下标越界
		for (int i = size - 1; i >= index; --i) {
			elements[i + 1] = elements[i];
		}
		elements[index] = e;
		++size;
	}

	public void update(int index, E e) {
		checkIndex(index);
		elements[index] = e;
	}

	public boolean remove(E e) {
		int i;
		for (i = 0; i < size; ++i) {
			if (Objects.equals(elements[i], e)) {
				break;
			}
		}
		if (i == size) {
			return false;
		}
		return remove(i);
	}

	public boolean remove(int index) {
		checkIndex(index);
		if (index < size - 1) {
			System.arraycopy(elements, index + 1, elements, index, size - index - 1);
		}
		size--;
		return true;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Require index >=0 and index < size.");
		}
	}

	private void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Require index >=0 and index <= size.");
		}
	}



	private void dilatation() {
		if (elements.length == size) {
			// 需要扩容
			Object[] newArray = new Object[elements.length / 2 + elements.length];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
		}
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		for (int i = 0; i < size; ++i) {
			joiner.add(elements[i].toString());
		}
		return joiner.toString();
	}

	public static void main(String[] args) {
		MyArrayList<Integer> arrayList = new MyArrayList<>();
		for (int i = 1; i < 10; ++i) {
			arrayList.add(i);
		}
		System.out.println(arrayList + " size = " + arrayList.size());

		arrayList.add(3, 30);

		System.out.println(arrayList + " size = " + arrayList.size());

//		arrayList.remove(new Integer(9));
//		System.out.println(arrayList + " size = " + arrayList.size());
//
//		arrayList.remove(new Integer(0));
//		System.out.println(arrayList + " size = " + arrayList.size());
//
//		arrayList.remove(3);
//		System.out.println(arrayList + " size = " + arrayList.size());
//
//		arrayList.remove(0);
//		System.out.println(arrayList + " size = " + arrayList.size());
//
//		arrayList.remove(arrayList.size() - 1);
//		System.out.println(arrayList + " size = " + arrayList.size());
//
//		arrayList.update(0, 0);
//		System.out.println(arrayList + " size = " + arrayList.size());
	}


}
