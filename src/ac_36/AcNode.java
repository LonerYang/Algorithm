package ac_36;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-22 12:45:14
 */
public class AcNode {

	public char data;

	/**
	 * 字符集只包含a-z这26个字符
	 */
	public AcNode[] children = new AcNode[26];

	public boolean isEndingChar = false;

	/**
	 * 当isEndingChar 为true时，记录模式串长度
	 */
	public int length = -1;

	/**
	 * 失败指针
	 */
	public AcNode fail;

	public AcNode(char data) {
		this.data = data;
	}

}
