package ac_36;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-22 12:48:48
 */
public class AcTrie {

	private AcNode root = new AcNode('/');

	public void insert(char[] text) {
		AcNode p = root;
		for (char c : text) {
			int index = c - 'a';
			if (p.children[index] == null) {
				p.children[index] = new AcNode(c);
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
		p.length = text.length;
	}


	public void buildFailurePointer() {
		Queue<AcNode> queue = new LinkedList<>();
		root.fail = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			AcNode p = queue.remove();
			for (int i = 0; i < 26; ++i) {
				AcNode pc = p.children[i];
				if (pc == null) continue;
				if (p == root) {
					pc.fail = root;
				} else {
					AcNode q = p.fail;
					while (q != null) {
						AcNode qc = q.children[pc.data - 'a'];
						if (qc != null) {
							pc.fail = qc;
							break;
						}
						q = q.fail;
					}
					if (q == null) {
						pc.fail = root;
					}
				}
				queue.add(pc);
			}
		}
	}


	public void match(char[] text) { // text是主串
		int n = text.length;
		AcNode p = root;
		for (int i = 0; i < n; ++i) {
			int idx = text[i] - 'a';
			while (p.children[idx] == null && p != root) {
				p = p.fail; // 失败指针发挥作用的地方
			}
			p = p.children[idx];
			if (p == null) {
				p = root; // 如果没有匹配的，从root开始重新匹配
			}
			AcNode tmp = p;
			while (tmp != root) { // 打印出可以匹配的模式串
				if (tmp.isEndingChar) {
					int pos = i - tmp.length + 1;
					System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
				}
				tmp = tmp.fail;
			}
		}
	}

	public static void main(String[] args) {
		String str1 = "she";
		String str2 = "shr";
		String str3 = "say";
		String str4 = "he";
		String str5 = "her";
		AcTrie acTrie = new AcTrie();
		acTrie.insert(str1.toCharArray());
		acTrie.insert(str2.toCharArray());
		acTrie.insert(str3.toCharArray());
		acTrie.insert(str4.toCharArray());
		acTrie.insert(str5.toCharArray());
		acTrie.buildFailurePointer();

		String text = "she";
		acTrie.match(text.toCharArray());
	}

}
