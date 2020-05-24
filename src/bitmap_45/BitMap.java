package bitmap_45;

/**
 * SLOGAN:码出高效！码出未来！
 *
 * @Description:
 * @author: <a href="mailto:miyang@dtstack.com">迷羊</a>
 * @Date: 2020-04-21 19:33:42
 */
public class BitMap {

	private char[] bytes;

	private int nbits;

	public BitMap(int nbits) {
		this.nbits = nbits;
		this.bytes = new char[nbits/16+1];
	}

	public void set(int k) {
		if (k > nbits) {
			return;
		}
		int byteIndex = k / 16;
		// 算出排第几位
		int bitIndex = k % 16;
		bytes[byteIndex] |= (1 << bitIndex);
	}

	public boolean get(int k) {
		if (k > nbits) return false;
		int byteIndex = k / 16;
		int bitIndex = k % 16;
		return (bytes[byteIndex] & (1 << bitIndex)) != 0;
	}

	public static void main(String[] args) {
		BitMap bitMap = new BitMap(2);
		bitMap.set(2);
		System.out.println(bitMap.get(3));
	}


}
