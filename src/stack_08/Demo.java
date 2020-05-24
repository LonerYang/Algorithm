package stack_08;

import java.util.Stack;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 模拟浏览器的前进后退功能
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-05-03 18:54:44
 */
public class Demo {

	public static void main(String[] args) {
		// x栈顶元素为页面显示的元素
		// 点击页面就将页面加入到x中，如果点击后退就将x中的元素弹出且压入到y中，点击前进就将y中的元素弹出且压入到x中
		Stack<String> x = new Stack<>();
		Stack<String> y = new Stack<>();
		x.push("a.html");
		x.push("b.html");
		x.push("c.html");
		System.out.println("x: " + x + ";" + "y: " + y);
		// 此时页面显示c.html；想看到a.html：后退两次
		y.push(x.pop());
		y.push(x.pop());
		// 此时x：a.html；y：c.html、b.html
		System.out.println("x: " + x + ";" + "y: " + y);
		// 想看到b.html：前进一次
		x.push(y.pop());
		// 此时x：a.html、b.html；y：c.html
		System.out.println("x: " + x + ";" + "y: " + y);
	}
}
