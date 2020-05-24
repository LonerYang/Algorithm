package trie_35;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-22 09:57:45
 */
public class Trie {

	private TrieNode root = new TrieNode('/');

	/**
	 * 往trie树中插入一个字符串
	 * @param text
	 */
	public void insert(char[] text) {
		TrieNode p = root;
		for (char c : text) {
			int index = c - 'a';
			if (p.children[index] == null) {
				p.children[index] = new TrieNode(c);
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
	}

	/**
	 * 在trie树中查找一个字符串
	 * @param text
	 * @return
	 */
	public boolean find(char[] text) {
		TrieNode p = root;
		for (char c : text) {
			int index = c - 'a';
			if (p.children[index] == null) {
				return false;
			}
			p = p.children[index];
		}
		if (!p.isEndingChar) {
			return false; // 只是前缀
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		char[] chars01 = {'a', 'b', 'c'};
		char[] chars02 = {'a', 'd'};
		char[] chars03 = {'c', 'd'};
		trie.insert(chars01);
		trie.insert(chars02);
		trie.insert(chars03);

		System.out.println(trie.find(chars02));
	}


}
