package queue_09;

import java.util.Arrays;

/**
 * 循环队列
 * @author Yang
 * @version 1.0
 * @time 2019/10/28
 */
public class CycleQueue {
	private String[] items;

	int capacity;

	int head = 0;

	int tail = 0;

	public CycleQueue(int capacity) {
		items = new String[capacity];
		this.capacity = capacity;
	}

	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		if ((tail + 1) % capacity == head) {
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % capacity;
		return true;
	}

	/**
	 * 出队
	 * @return
	 */
	public String dequeue() {
		if (head == tail) {
			return null;
		}
		String result = items[head];
		head = (head + 1) % capacity;
		return result;
	}

	@Override
	public String toString() {
		return "CycleQueue{" +
				"items=" + Arrays.toString(items) +
				'}';
	}

	public static void main(String[] args) {
		CycleQueue queue = new CycleQueue(8);
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i + "");
		}
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
