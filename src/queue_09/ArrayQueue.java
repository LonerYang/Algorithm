package queue_09;

import java.util.Arrays;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/10/28
 */
public class ArrayQueue {

	private String[] items;

	int capacity;

	int head = 0;

	int tail = 0;

	public ArrayQueue(int capacity) {
		items = new String[capacity];
		this.capacity = capacity;
	}

	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue01(String item) {
		if (tail == capacity) {
			return false;
		}
		items[tail] = item;
		tail++;
		return true;
	}

	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue02(String item) {
		// 如果tail == capacity && head == 0 代表队列已经满了
		if (tail == capacity) {
			if (head == 0) {
				return false;
			}
			// 搬移数据
			for (int i = head; i < capacity; i++) {
				items[i - head] = items[i];
			}
			// 重置head和tail的位置
			tail = tail - head;
			head = 0;
		}
		items[tail] = item;
		tail++;
		return true;
	}

	/**
	 * 出队
	 * @return
	 */
	public String dequeue() {
		// 如果head == tail 代表队列没有数据
		if (head == tail) {
			return null;
		}
		String result = items[head];
		head++;
		return result;
	}

	@Override
	public String toString() {
		return "ArrayQueue{" +
				"items=" + Arrays.toString(items) +
				'}';
	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(5);
		for (int i = 0; i < 5; i++) {
			queue.enqueue02(i + "");
		}
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue02("test");
		System.out.println(queue);
	}
}
