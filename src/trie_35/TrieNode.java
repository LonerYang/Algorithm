package trie_35;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-22 09:54:10
 */
public class TrieNode {

	char data;

	boolean isEndingChar = false;

	/**
	 * 假设字符串只有从a到z这26个小写字母
	 */
	TrieNode children[] = new TrieNode[26];

	public TrieNode(char data) {
		this.data = data;
	}
}
