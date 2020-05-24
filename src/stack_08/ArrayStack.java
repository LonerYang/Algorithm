package stack_08;

import java.util.Arrays;

/**
 * 数组实现的顺序栈
 * @author Yang
 * @version 1.0
 * @time 2019/10/27
 */
public class ArrayStack {
	/**
	 * 定义数组
	 */
	private String elements[];

	/**
	 * 栈的大小
	 */
	private int capacity;

	/**
	 * 栈中元素的个数
	 */
	private int count;

	public ArrayStack(int capacity) {
		this.capacity = capacity;
		count = 0;
		elements = new String[capacity];
	}

	/**
	 * 压栈
	 * @param element
	 * @return
	 */
	public boolean push(String element) {
		if (count == capacity) {
			return false;
		}
		elements[count] = element;
		count++;
		return true;
	}

	/**
	 * 出栈
	 * @return
	 */
	public String pop() {
		if (count == 0) {
			return null;
		}
		String result = elements[count - 1];
		count--;
		return result;
	}

	@Override
	public String toString() {
		return "ArrayStack{" +
				"elements=" + Arrays.toString(elements) +
				'}';
	}

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(5);
		for (int i = 0; i < 5; i++) {
			stack.push(i + "");
		}
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}

