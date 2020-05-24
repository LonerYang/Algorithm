package recall_39;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description: 八皇后问题
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-03-23 16:21:26
 */
public class EightQueens {

	/**
	 * 存储八皇后的位置
	 * 下标表示行，值表示列
	 */
	private int[] result = new int[8];

	private void cal8Queens(int row) {
		if (row == 8) {
			print8Queens();
			return;
		}
		for (int column = 0; column < 8; ++column) {
			if (isOk(row, column)) {
				result[row] = column;
				// 考察下一行
				cal8Queens(row + 1);
			}
		}
	}

	private boolean isOk(int row, int column) {
		int leftUp = column - 1;
		int rightUp = column + 1;
		// 考察上面每一行
		for (int i = row - 1; i >= 0; --i) {
			// 判断中上、左上、右上有没有皇后
			// 不用判断下面的。因为子程序也会调用该检查函数，自然不会存在下面出现不符合规则的情况
			// 上面的单元格有没有皇后
			if (result[i] == column) {
				return false;
			}
			// 左上的单元格有没有皇后
			if (leftUp >= 0 && result[i] == leftUp) {
				return false;
			}
			// 右上的单元格有没有皇后
			if (rightUp < 8 && result[i] == rightUp) {
				return false;
			}
			--leftUp;
			++rightUp;
		}
		return true;
	}

	private void print8Queens() {
		for (int row = 0; row < 8; ++row) {
			for (int column = 0; column < 8; ++column) {
				if (result[row] == column) {
					System.out.print("Q ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		EightQueens queens = new EightQueens();
		queens.cal8Queens(0);
	}

}
