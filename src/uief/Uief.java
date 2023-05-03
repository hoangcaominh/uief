package uief;

import java.math.*;

/**
 * A simple encoder and decoder for converting a message into a real number in the unit interval range and vice versa.
 * @author hoangcaominh
 *
 */
public class Uief {
	/**
	 * Encode a message in ASCII format into a real number between 0 and 1.
	 * @param message The message to be encoded.
	 * @return A value of BigDecimal type between 0 and 1.
	 */
	public BigDecimal encode(String message) {
		String d = "";
		for (int i = 0; i < message.length(); i++) {
			d += String.format("%03d", (int)message.charAt(i));
		}
		return new BigDecimal(String.format("0.%s", d));
	}
	
	/**
	 * Decode a real number into a message in ASCII format.
	 * @param number The real number to be decoded.
	 * @return A string representing the decoded message.
	 */
	public String decode(BigDecimal number) {
		String s = "";
		while (number.compareTo(BigDecimal.ZERO) > 0) {
			number = number.multiply(BigDecimal.valueOf(1000));
			int a = number.intValue();
			number = number.subtract(BigDecimal.valueOf(a));
			s += (char)a;
		}
		return s;
	}
}
