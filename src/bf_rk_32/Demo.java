package bf_rk_32;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 字符串匹配算法：BF & RK
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-02-11 19:01:43
 */
public class Demo {

	private static int bf(String mainStr, String patternStr) {
		int n = mainStr.length();
		int m = patternStr.length();
		char[] mainCharArr = mainStr.toCharArray();
		char[] patternCharArr = patternStr.toCharArray();

		for (int i = 0; i <= n - m; ++i) {
			int k = 0;
			for (int j = 0; j < m; ++j) {
				if (mainCharArr[i + j] == patternCharArr[j]) {
					++k;
				} else {
					break;
				}
			}
			if (k == m) {
				return i;
			}
		}
		return -1;
	}

	private static int rk(String mainStr, String patternStr) {
		int n = mainStr.length();
		int m = patternStr.length();
		char[] mainCharArr = mainStr.toCharArray();
		char[] patternCharArr = patternStr.toCharArray();
		// 存储所有字串的hash值
		int[] hash = new int[n - m + 1];
		// 存储26的次法，省略后面循环计算的时间
		int[] table = new int[26];
		int s = 1;
		// 将26的次方存储在一个表里，取的时候直接用,虽然溢出，除非模式串很大否则一般用不到溢出的
		for (int i = 0; i < 26; ++i) {
			table[i] = s;
			s *= 26;
		}

		for (int i = 0; i <= n - m; ++i) {
			int subHashVal = 0;
			// 计算每个子串的哈希值
			for (int j = 0; j < m; ++j) {
				subHashVal += (mainCharArr[i + j] - 'a') * table[m - 1 - j];
			}
			hash[i] = subHashVal;
		}
		// 计算模式串的哈希值
		int patternHashVal = 0;
		for (int i = 0; i < m; ++i) {
			patternHashVal += (patternCharArr[i] - 'a') * table[m - 1 - i];
		}
		// 比对模式串和字串的哈希值
		for (int i = 0; i < n - m + 1; i++) {
			if (hash[i] == patternHashVal) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String mainStr = "abcdefghijk";
		String patternStr = "fgh";
		System.out.println(bf(mainStr, patternStr));
		System.out.println(rk(mainStr, patternStr));
	}

}
